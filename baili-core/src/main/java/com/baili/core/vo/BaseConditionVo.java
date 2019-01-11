package com.baili.core.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
* @ClassName: BaseConditionVO 
* @Description: TODO(分页条件) 
* @author zhumingming 
* @date 2018年6月1日 下午4:17:12 
*
 */
@ApiModel(description="条件信息")
public class BaseConditionVo {
	
	public final static int DEFAULT_PAGE_SIZE = 10;//默认每页多少条
	@ApiModelProperty(value="当前第几页")
	private int pageNumber = 1;//多少页
	@ApiModelProperty(value="每页多少条")
	private int pageSize = 0;
	
	@SuppressWarnings("unused")
	private int pageStart = 0;
	@ApiModelProperty(value="开始时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	@ApiModelProperty(value="结束时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate;

	public int getPageSize() {
		return pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
	}

	public int getPageStart() {
		return pageNumber > 0 ? (pageNumber - 1) * getPageSize() : 0;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

}
