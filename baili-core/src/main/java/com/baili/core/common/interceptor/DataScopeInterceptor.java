package com.baili.core.common.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import com.baili.core.common.annotation.CompanyAnnotation;
import com.baili.core.common.emus.CompanyCode;
import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.common.exception.MyException;
import com.baili.core.entity.User;
import com.baomidou.mybatisplus.toolkit.PluginUtils;


import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Properties;

/**
 * 
* @ClassName: DataScopeInterceptor 
* @Description: TODO(数据权限分类查询拦截器) 
* @author zhumingming 
* @date 2018年12月6日 下午2:52:40 
*
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
@Component
public class DataScopeInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) PluginUtils.realTarget(invocation.getTarget());
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		if (!SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())) {
			return invocation.proceed();
		}
		Class<?> classType = Class.forName(mappedStatement.getId().substring(0, mappedStatement.getId().lastIndexOf(".")));
		CompanyAnnotation companyAnnotation = null;
		// 判断是否加了注解
		for (Method method : classType.getDeclaredMethods()) {
			if (!method.isAnnotationPresent(CompanyAnnotation.class)) {
				return invocation.proceed();
			}
			companyAnnotation = method.getAnnotation(CompanyAnnotation.class);
		}
		String alias = companyAnnotation.Alias();

		BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
		String originalSql = boundSql.getSql();
		// 对sql进行处理
		originalSql = getSql(originalSql, alias);
		metaStatementHandler.setValue("delegate.boundSql.sql", originalSql);
		return invocation.proceed();

	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

	private String getSql(String originalSql, String alias) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		Long id = 0l;// 创建人公司id 或者用户id
		String sql = "";
		if (user != null) {
			if (alias == null || "".equals(alias) || CompanyCode.COMPANY.equals(alias)) {
				id = user.getCompanyId();
				sql = "created_by_company_id=" + id;
			} else if (CompanyCode.USER.equals(alias)) {
				id = user.getId();
				sql = "created_by_id=" + id;
			} else {
				throw new MyException(ResponseStatusEnum.ANNOTATION_VALUE_ERROR);
			}
		}
		if (originalSql.indexOf("SELECT count(0) FROM") > -1) {
			if (originalSql.indexOf("WHERE") > -1) {
				originalSql = originalSql + "  and " + sql;
			} else {
				originalSql = originalSql + " where   " + sql;
			}
		} else {
			originalSql = "select v.* from (" + originalSql + ") v  where v." + sql;
		}

		return originalSql;
	}

}
