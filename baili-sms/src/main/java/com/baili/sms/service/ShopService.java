package com.baili.sms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baili.sms.entity.Shop;
import com.baili.sms.entity.vo.ShopConditionVo;
import com.baili.sms.mapper.ShopMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: AttributeKeyService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2018年12月6日 下午3:36:14
 *
 */
@Service
@Transactional
public class ShopService {

	@Autowired
	private ShopMapper shopMapper;

	public void addShop(Shop shop) {
		shopMapper.insert(shop);

	}

	public void deleteShop(Long id) {
		shopMapper.deleteByPrimaryKey(id);

	}

	public void updateShop(Shop shop) {
		shopMapper.updateByPrimaryKey(shop);

	}

	public Shop findShopById(Long id) {
		return shopMapper.selectByPrimaryKey(id);
	}

	public PageInfo<Shop> findShopList(ShopConditionVo vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
		List<Shop> objs = shopMapper.findPageBreakByCondition(vo);
		PageInfo<Shop> bean = new PageInfo<Shop>(objs);
		bean.setList(objs);
		return bean;
	}

}
