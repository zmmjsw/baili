package com.baili.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.vo.ResponseVo;
import com.github.pagehelper.PageInfo;


/**
 * 
* @ClassName: ResultUtil 
* @Description: TODO(返回视图) 
* @author zhumingming 
* @date 2018年6月4日 下午4:21:00 
*
 */
public class ResultUtil {
	  public static ModelAndView view(String view) {
	        return new ModelAndView(view);
	    }

	    public static ModelAndView view(String view, Map<String, Object> model) {
	        return new ModelAndView(view, model);
	    }

	    public static ModelAndView redirect(String view) {
	        return new ModelAndView("redirect:" + view);
	    }

	    public static <T>ResponseVo<T> error(int code, String message) {
	        return vo(code, message, null);
	    }

	    public static <T>ResponseVo<T> error(ResponseStatusEnum status) {
	        return vo(status.getCode(), status.getMessage(), null);
	    }

	    public static <T>ResponseVo<T> error(String message) {
	        return vo(ResponseStatusEnum.ERROR.getCode(), message, null);
	    }

	    public static <T>ResponseVo<T> success(String message, T data) {
	        return vo(ResponseStatusEnum.SUCCESS.getCode(), message, data);
	    }

	    public static <T>ResponseVo<T> success(String message) {
	        return success(message, null);
	    }

	    public static <T>ResponseVo<T> success(ResponseStatusEnum status) {
	        return vo(status.getCode(), status.getMessage(), null);
	    }

	    public static <T>ResponseVo<T> vo(int code, String message, T data) {
	        return new ResponseVo<T>(code, message, data);
	    }

	    public static <T> PageResult<T> tablePage(Long total, List<T> rows, Integer pages,Integer totalNum,boolean isFirstPage   ,boolean isLastPage ,boolean  hasPreviousPage ,boolean hasNextPage,ResponseStatusEnum num) {
	        return new PageResult<T>(total, rows,pages,totalNum,isFirstPage,isLastPage,hasPreviousPage,hasNextPage,num.getCode(),num.getMessage());
	    }

	    public static <T> PageResult<T> tablePage(PageInfo<T> info,ResponseStatusEnum num) {
	        if (info == null) {
	            return new PageResult<T>(0L, new ArrayList<T>(),0,0,false,false,false,false,200,"");
	        }
	        return tablePage(info.getTotal(), info.getList(),info.getPages(),info.getPageNum(),info.isIsFirstPage(),info.isIsLastPage(),info.isHasPreviousPage(),info.isHasNextPage(),num);
	    }

}
