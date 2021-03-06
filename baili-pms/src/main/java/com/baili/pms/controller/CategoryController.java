package com.baili.pms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.util.PageResult;
import com.baili.core.util.ResultUtil;
import com.baili.core.vo.ResponseVo;
import com.baili.pms.entity.Category;
import com.baili.pms.entity.vo.CategoryConditionVo;
import com.baili.pms.service.CategoryService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: CategoryController 
* @Description: TODO(类别) 
* @author zhumingming 
* @date 2018年12月3日 下午2:04:18 
*
 */

@Api(value="类别controller",tags={"类别操作接口"})
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add")
	@ApiOperation(value="添加类别信息")
	public ResponseVo<Void> addCategroy(@Valid@RequestBody Category category) {
		categoryService.addCategory(category);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/delete")
	@ApiOperation(value="删除类别")
	public ResponseVo<Void> deleteCategroy(@NonNull@RequestParam(value = "id") Long id) {
		categoryService.deleteCategory(id);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/update")
	@ApiOperation(value="修改类别")
	public ResponseVo<Void> updateCategroy(@Valid@RequestBody Category category) {
		categoryService.updateCategory(category);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/findOne")
	@ApiOperation(value="根据id查询类别详情")
	public ResponseVo<Category> findCategroyById(@RequestParam(value = "id") Long id) {
		return new ResponseVo<Category>(ResponseStatusEnum.SUCCESS, categoryService.findCategoryById(id));
	}
	
	@PostMapping("/findList")
	@ApiOperation(value="产品列表",notes="根据条件查询产品列表")
	public PageResult<Category> findAllCategroy(@Valid@RequestBody CategoryConditionVo vo) {
		PageInfo<Category> Products = categoryService.findCategoryList(vo);
		return ResultUtil.tablePage(Products,ResponseStatusEnum.SUCCESS);
	}


}
