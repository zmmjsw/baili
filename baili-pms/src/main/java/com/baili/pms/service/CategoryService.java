package com.baili.pms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.common.exception.MyException;
import com.baili.pms.entity.Category;
import com.baili.pms.entity.vo.CategoryConditionVo;
import com.baili.pms.mapper.CategoryMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: CategoryService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2018年12月3日 下午2:07:04
 *
 */
@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	public void addCategory(Category category) {
		categoryMapper.insert(category);

	}

	public void deleteCategory(Long id) {
		if (categoryMapper.deleteByPrimaryKey(id) > 0) {
			throw new MyException(ResponseStatusEnum.DELETE_ERROR_CATEGORY);
		}
	}

	public void updateCategory(Category category) {
		categoryMapper.updateByPrimaryKey(category);

	}

	public Category findCategoryById(Long id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	public PageInfo<Category> findCategoryList(CategoryConditionVo vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
		List<Category> Products = categoryMapper.findPageBreakByCondition(vo);
		PageInfo<Category> bean = new PageInfo<Category>(Products);
		bean.setList(Products);
		return bean;
	}

}
