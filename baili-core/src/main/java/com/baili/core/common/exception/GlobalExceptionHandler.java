package com.baili.core.common.exception;


import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.common.exception.MyException;
import com.baili.core.util.ValidateUtility;
import com.baili.core.vo.ResponseVo;

/**
 * 
 * @ClassName: GlobalExceptionHandler
 * @Description: TODO(全局异常统一处理)
 * @author zhumingming
 * @date 2017年12月7日 下午5:55:14
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 
	 * @Title: notFount
	 * @Description: TODO(拦截业务异常)
	 * @return ErrorInfo 返回类型
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(MyException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseVo<ResponseStatusEnum> notFount(MyException e, HttpServletRequest req) {
		log.info("错误信息{},错误路径{}", e.getMessage(),req.getRequestURL().toString());
		return new ResponseVo(e.getCode(), e.getMessage(), req.getRequestURL().toString());
	}

	
	
	
	/**
	 * 
	 * @Title: notFount
	 * @Description: TODO(拦截权限异常)
	 * @return ErrorInfo 返回类型
	 */
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseVo<ResponseStatusEnum> notFount(UnauthorizedException e, HttpServletRequest req) {
		log.info("错误信息{},错误路径{}", e.getMessage(),req.getRequestURL().toString());
		return new ResponseVo<ResponseStatusEnum>(ResponseStatusEnum.FORBIDDEN);
	}
	
	
	/**
	 * 
	 * @Title: notFount
	 * @Description: TODO(拦截登录异常)
	 * @return ErrorInfo 返回类型
	 */                           
	@ExceptionHandler(AuthorizationException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseVo<ResponseStatusEnum> notFount(AuthorizationException e, HttpServletRequest req) {
		log.info("错误信息{},错误路径{}", e.getMessage(),req.getRequestURL().toString());
		return new ResponseVo<ResponseStatusEnum>(ResponseStatusEnum.UNAUTHORIZED);
	}
	
	/**
	 * 
	 * @Title: notFount
	 * @Description: TODO(拦截未知的运行时异常)
	 * @return ErrorInfo 返回类型
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseVo<ResponseStatusEnum> notFount(RuntimeException e, HttpServletRequest req) {
		log.info("错误信息{},错误路径{}", e.getMessage(),req.getRequestURL().toString());
		return new ResponseVo<ResponseStatusEnum>(ResponseStatusEnum.ERROR);
	}

	/**
	 * 
	 * @Title: notFount
	 * @Description: TODO(拦截参数错误异常)
	 * @return ErrorInfo 返回类型
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseVo<ResponseStatusEnum> notFount(MethodArgumentNotValidException e, HttpServletRequest req) {
		log.info("错误信息{},错误路径{},错误描述{}", e.getMessage(),req.getRequestURL().toString(),ValidateUtility.judgeValidate(e.getBindingResult()));
		return new ResponseVo<ResponseStatusEnum>(ResponseStatusEnum.NOT_VALID);
	}
	
	
	/**
	 * 
	 * @Title: notFount
	 * @Description: TODO(拦截参数错误异常)
	 * @return ErrorInfo 返回类型
	 */
	@ExceptionHandler(ArithmeticException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseVo<ResponseStatusEnum> notFount(ArithmeticException e, HttpServletRequest req) {
		log.info("错误信息{},错误路径{}", e.getMessage(),req.getRequestURL().toString());
		return new ResponseVo<ResponseStatusEnum>(ResponseStatusEnum.ERROR);
	}
	
	/**
	 * 
	 * @Title: notFount
	 * @Description: TODO(拦截权限错误异常)
	 * @return ErrorInfo 返回类型
	 */
	@ExceptionHandler(UnauthenticatedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseVo<ResponseStatusEnum> notFount(UnauthenticatedException e, HttpServletRequest req) {
		log.info("错误信息{},错误路径{}", e.getMessage(),req.getRequestURL().toString());
		return new ResponseVo<ResponseStatusEnum>(ResponseStatusEnum.FORBIDDEN);
	}
	
	/**
	 * 
	 * @Title: notFount
	 * @Description: TODO(拦截缓存错误异常)
	 * @return ErrorInfo 返回类型
	 */
	@ExceptionHandler(SpelEvaluationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseVo<ResponseStatusEnum> notFount(SpelEvaluationException e, HttpServletRequest req) {
		log.info("错误信息{},错误路径{}", e.getMessage(),req.getRequestURL().toString());
		return new ResponseVo<ResponseStatusEnum>(ResponseStatusEnum.EL);
	}
	
	
	
	
	
	
	

}
