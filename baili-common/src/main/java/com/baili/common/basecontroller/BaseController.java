package com.baili.common.basecontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *@描述 controller基类
 *@参数
 *@返回值
 *@创建人  Eric
 *@创建时间  2018/9/14
 *@修改人和其它信息
 */
public abstract class BaseController {

    protected   Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *获取携带参数
     * @return
     */
    public PageData getPageData(){
        return new PageData(this.getRequest());
    }
    /**得到request对象
     * @return
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

}