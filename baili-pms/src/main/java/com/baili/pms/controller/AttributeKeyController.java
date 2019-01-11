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
import com.baili.pms.entity.AttributeKey;
import com.baili.pms.entity.vo.AttributeKeyConditionVo;
import com.baili.pms.service.AttributeKeyService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: AttributeKeyController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年12月6日 下午3:33:39 
*
 */

@Api(value="规格健controller",tags={"规格健"})
@RestController
@RequestMapping("/attributeKey")
public class AttributeKeyController {
	
	@Autowired
	private AttributeKeyService attributeKeyService;
	
	@PostMapping("/add")
	@ApiOperation(value="添加规格健")
	public ResponseVo<Void> addAttributeKey(@Valid@RequestBody AttributeKey attributeKey) {
		attributeKeyService.addattributeKey(attributeKey);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/delete")
	@ApiOperation(value="删除规格健")
	public ResponseVo<Void> deleteAttributeKey(@NonNull@RequestParam(value = "id") Long id) {
		attributeKeyService.deleteattributeKey(id);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/update")
	@ApiOperation(value="修改规格健")
	public ResponseVo<Void> updateAttributeKey(@Valid@RequestBody AttributeKey attributeKey) {
		attributeKeyService.updateAttributeKey(attributeKey);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/findOne")
	@ApiOperation(value="根据id查询规格健详情")
	public ResponseVo<AttributeKey> findAttributeKeyById(@RequestParam(value = "id") Long id) {
		return new ResponseVo<AttributeKey>(ResponseStatusEnum.SUCCESS, attributeKeyService.findAttributeKeyById(id));
	}
	
	@PostMapping("/findList")
	@ApiOperation(value="规格健列表",notes="根据条件查询规格健列表")
	public PageResult<AttributeKey> findAllAttributeKey(@Valid@RequestBody AttributeKeyConditionVo vo) {
		PageInfo<AttributeKey> Products = attributeKeyService.findAttributeKeyList(vo);
		return ResultUtil.tablePage(Products,ResponseStatusEnum.SUCCESS);
	}


}
