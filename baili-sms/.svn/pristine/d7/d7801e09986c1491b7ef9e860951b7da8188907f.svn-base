package com.baili.sms.controller;

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
import com.baili.sms.entity.Shop;
import com.baili.sms.entity.vo.ShopConditionVo;
import com.baili.sms.service.ShopService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: ShopController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年12月6日 下午3:33:39 
*
 */

@Api(value="店铺controller",tags={"店铺"})
@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopService ShopService;
	
	@PostMapping("/add")
	@ApiOperation(value="添加店铺")
	public ResponseVo<Shop> addShop(@Valid@RequestBody Shop shop) {
		ShopService.addShop(shop);
		return new ResponseVo<Shop>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/delete")
	@ApiOperation(value="删除店铺")
	public ResponseVo<Shop> deleteShop(@NonNull@RequestParam(value = "id") Long id) {
		ShopService.deleteShop(id);
		return new ResponseVo<Shop>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/update")
	@ApiOperation(value="修改店铺")
	public ResponseVo<Shop> updateShop(@Valid@RequestBody Shop shop) {
		ShopService.updateShop(shop);
		return new ResponseVo<Shop>(ResponseStatusEnum.SUCCESS);
	}
	
	@PostMapping("/findOne")
	@ApiOperation(value="根据id查询店铺详情")
	public ResponseVo<Shop> findShopById(@RequestParam(value = "id") Long id) {
		return new ResponseVo<Shop>(ResponseStatusEnum.SUCCESS, ShopService.findShopById(id));
	}
	
	@PostMapping("/findList")
	@ApiOperation(value="店铺列表",notes="根据条件查询店铺列表")
	public PageResult<Shop> findAllShop(@Valid@RequestBody ShopConditionVo vo) {
		PageInfo<Shop> Products = ShopService.findShopList(vo);
		return ResultUtil.tablePage(Products,ResponseStatusEnum.SUCCESS);
	}


}
