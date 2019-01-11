package com.baili.core.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
* @ClassName: CompanyAnnotation 
* @Description: TODO(查询时根据用户id或者公司id查询信息的用这个注解) 
* @author zhumingming 
* @date 2018年12月6日 下午3:20:37 
*
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CompanyAnnotation {
	
	/**
     * 别名（针对复杂查询处理属性）
     * @return
     */
    String Alias() default "";

}
