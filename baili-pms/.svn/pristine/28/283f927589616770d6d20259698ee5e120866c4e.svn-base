package com.baili.pms.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baili.pms.entity.AttributeKey;
import com.baili.pms.entity.vo.AttributeKeyConditionVo;
import com.baili.pms.mapper.AttributeKeyMapper;
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
public class AttributeKeyService {

	@Autowired
	private AttributeKeyMapper attributeKeyMapper;

	public void addattributeKey(AttributeKey attributeKey) {
		attributeKeyMapper.insert(attributeKey);

	}

	public void deleteattributeKey(Long id) {
		attributeKeyMapper.deleteByPrimaryKey(id);
	}

	public void updateAttributeKey(@Valid AttributeKey attributeKey) {
		attributeKeyMapper.updateByPrimaryKey(attributeKey);
		
	}
	
	public  AttributeKey findAttributeKeyById(Long id) {
		return attributeKeyMapper.selectByPrimaryKey(id);
	}

	public PageInfo<AttributeKey> findAttributeKeyList( AttributeKeyConditionVo vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
		List<AttributeKey> objs = attributeKeyMapper.findPageBreakByCondition(vo);
		PageInfo<AttributeKey> bean = new PageInfo<AttributeKey>(objs);
		bean.setList(objs);
		return bean;
	}





}
