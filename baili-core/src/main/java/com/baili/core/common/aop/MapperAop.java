package com.baili.core.common.aop;

import java.util.Date;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;
import com.baili.core.entity.User;
import com.github.pagehelper.util.StringUtil;

/**
 * 
 * @ClassName: MapperAop
 * @Description: TODO(切面编程，mapper注入创建人修改人)
 * @author zhumingming
 * @date 2018年6月21日 上午10:39:34
 *
 */
@Aspect
@Component
public class MapperAop {

	/**
	 * 
	 * @ClassName: OperateAspect
	 * @Description: TODO(添加的切面)
	 * @author zhumingming
	 * @date 2018年6月21日 上午10:40:25
	 *
	 */
	@Pointcut("execution(* com.baili.*.mapper.*.insert*(..))")
	public void saveEntity() {
	}

	@Before("saveEntity()")
	public void beforeSave(JoinPoint jp) throws Exception, Exception {
		// 这个参数从域里获取。为用户名
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		Long companyId = 0l;// 创建人公司id
		Long userId = 0l;// 创建人id
		String userName = "测试用户";// 创建人名字
		String companyName = "";// 创建人公司名字
		if (user != null) {
			userName = user.getName();
			userId=user.getId();
			companyId = user.getCompanyId();
			companyName = user.getCompany().getCompanyName();
		}
		Object[] args = jp.getArgs();
		if (args != null && args.length > 0) {
			Object argument = args[0];
			BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
			// 设置创建时间和修改时间
			if (beanWrapper.isWritableProperty("createTime")) {
				beanWrapper.setPropertyValue("createTime", new Date());
			}
			if (beanWrapper.isWritableProperty("updateTime")) {
				beanWrapper.setPropertyValue("updateTime", new Date());
			}
			// 设置创建人
			if (beanWrapper.isWritableProperty("createdBy") && StringUtil.isNotEmpty(userName)) {
				beanWrapper.setPropertyValue("createdBy", userName);
			} // 创建人id
			if (beanWrapper.isWritableProperty("createdById") && userId != null && userId != 0) {
				beanWrapper.setPropertyValue("createdById", userId);
			} // 修改人
			if (beanWrapper.isWritableProperty("updatedBy") && StringUtil.isNotEmpty(userName)) {
				beanWrapper.setPropertyValue("updatedBy", userName);
			}
			// 创建人公司id
			if (beanWrapper.isWritableProperty("createdByCompanyId") && companyId != null && companyId != 0) {
				beanWrapper.setPropertyValue("createdByCompanyId", companyId);
			}
			// 创建人公司名字
			if (beanWrapper.isWritableProperty("createdByCompanyName") && StringUtil.isNotEmpty(companyName)) {
				beanWrapper.setPropertyValue("createdByCompanyName", companyName);
			}
		}
	}

	/**
	 * 
	 * @Title: updateEntity
	 * @Description: TODO(修改的切面)
	 * @return void 返回类型
	 */
	@Pointcut("execution(* com.baili.*.mapper.*.update*(..))")
	public void updateEntity() {
	}

	@Before("updateEntity()")
	public void beforeUpdate(JoinPoint jp) throws Exception, Exception {
		// 这个参数从域里获取。为用户名
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		String userName = "测试用户";
		if (user != null) {
			userName = user.getName();
		}
		Object[] args = jp.getArgs();
		// myBatis只能传递一个参数
		if (args != null && args.length > 0) {
			Object argument = args[0];
			BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
			if (beanWrapper.isWritableProperty("updateTime")) {
				beanWrapper.setPropertyValue("updateTime", new Date());
			}
			if (beanWrapper.isWritableProperty("updatedBy") && StringUtil.isNotEmpty(userName)) {
				beanWrapper.setPropertyValue("updatedBy", userName);
			}

		}
	}
	
	


}