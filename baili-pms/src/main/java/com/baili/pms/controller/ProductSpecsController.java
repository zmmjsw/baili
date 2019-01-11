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
import com.baili.pms.entity.ProductSpecs;
import com.baili.pms.entity.vo.ProductSpecsConditionVo;
import com.baili.pms.service.ProductSpecsService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: ProductSpecsController 
* @Description: TODO(产品规格sku) 
* @author zhumingming 
* @date 2018年12月3日 下午2:59:17 
*
 */


@Api(value="产品规格skucontroller",tags={"产品规格操作接口"})
@RestController
@RequestMapping("/productSpecs")
public class ProductSpecsController {
	
	@Autowired
	private ProductSpecsService productSpecsService;
	
	@PostMapping("/add")
	@ApiOperation(value="添加产品信息")
	public ResponseVo<Void> addProductSpecs(@Valid@RequestBody ProductSpecs productSpecs) {
		productSpecsService.addProductSpecs(productSpecs);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/delete")
	@ApiOperation(value="删除")
	public ResponseVo<Void> deleteProductSpecs(@NonNull@RequestParam(value = "id") Long id) {
		productSpecsService.deleteProductSpecs(id);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/update")
	@ApiOperation(value="修改")
	public ResponseVo<Void> updateProductSpecs(@Valid@RequestBody ProductSpecs productSpecs) {
		productSpecsService.updateProductSpecs(productSpecs);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/findOne")
	@ApiOperation(value="根据id查询详情")
	public ResponseVo<ProductSpecs> findProductSpecsById(@RequestParam(value = "id") Long id) {
		return new ResponseVo<ProductSpecs>(ResponseStatusEnum.SUCCESS, productSpecsService.findProductSpecsById(id));
	}
	
	@PostMapping("/findList")
	@ApiOperation(value="列表")
	public PageResult<ProductSpecs> findAllProductSpecs(@Valid@RequestBody ProductSpecsConditionVo vo) {
		PageInfo<ProductSpecs> Products = productSpecsService.findProductSpecsList(vo);
		return ResultUtil.tablePage(Products,ResponseStatusEnum.SUCCESS);
	}

}
