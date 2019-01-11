package com.baili.account.service;

import java.util.List;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baili.account.entity.vo.CompanyConditionVo;
import com.baili.account.mapper.CompanyMapper;
import com.baili.core.entity.Company;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: CompanyService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2018年12月6日 下午4:54:33
 *
 */

@Service
@Transactional
public class CompanyService {

	@Autowired
	private CompanyMapper companyMapper;

	public void addCompany(Company company) {
		companyMapper.insert(company);
	}

	public void deleteCompanyById(@NotNull Long id) {
		companyMapper.deleteByPrimaryKey(id);
	}

	public Company findCompanyById(@NotNull Long id) {
		return companyMapper.selectByPrimaryKey(id);
	}

	public PageInfo<Company> findCompanyList(CompanyConditionVo vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
		List<Company> objs = companyMapper.findPageBreakByCondition(vo);
		PageInfo<Company> bean = new PageInfo<Company>(objs);
		bean.setList(objs);
		return bean;
	}

}
