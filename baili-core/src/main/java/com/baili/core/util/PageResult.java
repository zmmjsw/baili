package com.baili.core.util;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: PageResult
 * @Description: TODO(分页返回)
 * @author zhumingming
 * @date 2018年6月4日 下午4:18:07
 *
 */
@ApiModel(value = "分页数据")
public class PageResult<T> {
	@ApiModelProperty(value = "总条数")
	private Long total;
	@ApiModelProperty(value = "信息列表")
	private List<T> rows;
	@ApiModelProperty(value = "总页数")
	private Integer pages;
	@ApiModelProperty(value = "当前页")
	private Integer pageNum;
	@ApiModelProperty(value = "是否为第一页")
	private boolean isFirstPage = false;
	@ApiModelProperty(value = "是否为最后一页")
	private boolean isLastPage = false;
	@ApiModelProperty(value = "是否有前一页")
	private boolean hasPreviousPage = false;
	@ApiModelProperty(value = "是否有下一页")
	private boolean hasNextPage = false;
	
	@ApiModelProperty(value="状态信息")
    private Integer status;
    @ApiModelProperty(value="状态码")
    private String message;

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
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

	public PageResult(Long total, List<T> rows, Integer pages, Integer pageNum, boolean isFirstPage, boolean isLastPage,
			boolean hasPreviousPage, boolean hasNextPage,Integer status,String message) {
		super();
		this.total = total;
		this.rows = rows;
		this.pages = pages;
		this.pageNum = pageNum;
		this.isFirstPage = isFirstPage;
		this.isLastPage = isLastPage;
		this.hasPreviousPage = hasPreviousPage;
		this.hasNextPage = hasNextPage;
		this.status = status;
		this.message = message;
	}

	public PageResult() {
		super();
	}

}
