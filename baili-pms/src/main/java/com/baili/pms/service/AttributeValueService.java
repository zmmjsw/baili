package com.baili.pms.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baili.pms.entity.AttributeValue;
import com.baili.pms.entity.vo.AttributeValueConditionVo;
import com.baili.pms.mapper.AttributeValueMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: AttributeValueService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2018年12月6日 下午3:36:14
 *
 */
@Service
@Transactional
public class AttributeValueService {

	@Autowired
	private AttributeValueMapper attributeValueMapper;

	public void addattributeValue(AttributeValue attributeValue) {
		attributeValueMapper.insert(attributeValue);

	}

	public void deleteattributeValue(Long id) {
		attributeValueMapper.deleteByPrimaryKey(id);
	}

	public void updateAttributeValue( AttributeValue attributeValue) {
		attributeValueMapper.updateByPrimaryKey(attributeValue);
		
	}
	
	public  AttributeValue findAttributeValueById(Long id) {
		return attributeValueMapper.selectByPrimaryKey(id);
	}

	public PageInfo<AttributeValue> findAttributeValueList( AttributeValueConditionVo vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
		List<AttributeValue> objs = attributeValueMapper.findPageBreakByCondition(vo);
		PageInfo<AttributeValue> bean = new PageInfo<AttributeValue>(objs);
		bean.setList(objs);
		return bean;
	}





}
