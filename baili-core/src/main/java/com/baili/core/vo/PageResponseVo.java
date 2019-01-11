package com.baili.core.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.util.PageResult;

/**
 * 
* @ClassName: ResponseVO 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年6月4日 下午4:22:20 
* 
* @param <T>
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="返回信息")
public class PageResponseVo<T> implements Serializable{
	    /** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -7975087087799058533L;
		@ApiModelProperty(value="状态信息")
	    private Integer status;
	    @ApiModelProperty(value="状态码")
	    private String message;
	    @ApiModelProperty(value="详情")
	    private PageResult<T> data;
	    

	    public PageResponseVo(Integer status, String message, PageResult<T> data) {
	        this.status = status;
	        this.message = message;
	        this.data = data;
	    }
	    
	    public PageResponseVo(ResponseStatusEnum status) {
	        this(status.getCode(), status.getMessage(),null);
	    }
	    

	    public PageResponseVo(ResponseStatusEnum status, PageResult<T> data ) {
	        this(status.getCode(), status.getMessage(), data);
	    }
	    

	    public String toJson() {
	        PageResult<T> t = this.getData();
	        if (t instanceof List || t instanceof Collection) {
	            return JSONObject.toJSONString(this, SerializerFeature.WriteNullListAsEmpty);
	        } else {
	            return JSONObject.toJSONString(this, SerializerFeature.WriteMapNullValue);
	        }
	    }

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public PageResult<T> getData() {
			return data;
		}

		public void setData(PageResult<T> data) {
			this.data = data;
		}

	    
	    
	    

}
