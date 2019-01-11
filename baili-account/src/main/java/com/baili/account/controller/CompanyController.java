package com.baili.account.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baili.account.entity.vo.CompanyConditionVo;
import com.baili.account.service.CompanyService;
import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.entity.Company;
import com.baili.core.util.PageResult;
import com.baili.core.util.ResultUtil;
import com.baili.core.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: CompanyController 
* @Description: TODO(公司controller) 
* @author zhumingming 
* @date 2018年11月23日 上午10:23:26 
*
 */
@Api(value = "公司controller", tags = { "公司操作接口" })
@RestController
@RequestMapping("/company")
public class CompanyController {
	
	

	@Autowired
	private CompanyService companyService;

	@PostMapping("/add")
	@ApiOperation(value="添加公司信息",notes="公司添加")
	public ResponseVo<Void> addCompany(@Valid@RequestBody Company company) {
		companyService.addCompany(company);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}

	@PostMapping("/delete")
	@ApiOperation(value="删除公司",notes="公司删除")
	public ResponseVo<Void> deleteCompany(@NotNull@RequestParam(value = "id") Long id) {
		companyService.deleteCompanyById(id);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}


	@GetMapping("/findOne")
	@ApiOperation(value="公司详情",notes="根据id查询公司")
	public ResponseVo<Company> findCompanyById(@NotNull@RequestParam(value = "id") Long id) {
		return new ResponseVo<Company>(ResponseStatusEnum.SUCCESS,companyService.findCompanyById(id));
	}

	@PostMapping("/findList")
	@ApiOperation(value="公司列表",notes="根据条件查询公司列表")
	public PageResult<Company> findAllCompany(@Valid@RequestBody CompanyConditionVo vo) {
		PageInfo<Company> permissions = companyService.findCompanyList(vo);
		return  ResultUtil.tablePage(permissions,ResponseStatusEnum.SUCCESS);
	}
	
	
	

}
