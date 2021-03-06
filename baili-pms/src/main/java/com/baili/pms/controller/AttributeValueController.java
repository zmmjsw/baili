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
import com.baili.pms.entity.AttributeValue;
import com.baili.pms.entity.vo.AttributeValueConditionVo;
import com.baili.pms.service.AttributeValueService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: AttributeValueController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年12月6日 下午3:33:39 
*
 */

@Api(value="规格值controller",tags={"规格值"})
@RestController
@RequestMapping("/attributeValue")
public class AttributeValueController {
	
	@Autowired
	private AttributeValueService attributeValueService;
	
	@PostMapping("/add")
	@ApiOperation(value="添加规格值")
	public ResponseVo<Void> addAttributeValue(@Valid@RequestBody AttributeValue attributeValue) {
		attributeValueService.addattributeValue(attributeValue);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/delete")
	@ApiOperation(value="删除规格值")
	public ResponseVo<Void> deleteAttributeValue(@NonNull@RequestParam(value = "id") Long id) {
		attributeValueService.deleteattributeValue(id);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/update")
	@ApiOperation(value="修改规格值")
	public ResponseVo<Void> updateAttributeValue(@Valid@RequestBody AttributeValue attributeValue) {
		attributeValueService.updateAttributeValue(attributeValue);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/findOne")
	@ApiOperation(value="根据id查询规格值详情")
	public ResponseVo<AttributeValue> findAttributeValueById(@RequestParam(value = "id") Long id) {
		return new ResponseVo<AttributeValue>(ResponseStatusEnum.SUCCESS, attributeValueService.findAttributeValueById(id));
	}
	
	@PostMapping("/findList")
	@ApiOperation(value="规格值列表",notes="根据条件查询规格值列表")
	public PageResult<AttributeValue> findAllAttributeValue(@Valid@RequestBody AttributeValueConditionVo vo) {
		PageInfo<AttributeValue> Products = attributeValueService.findAttributeValueList(vo);
		return ResultUtil.tablePage(Products,ResponseStatusEnum.SUCCESS);
	}


}
