package com.springboot.mybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mybatis.domain.Company;
import com.springboot.mybatis.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "员工相关接口")
@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    /**
     * 分页查询所有员工
     */
    @ApiOperation("分页查询所有员工")
    @GetMapping("/pages")
    public PageInfo<Company> lists(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Company> list = companyService.selectAllStaff();
        PageInfo<Company> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    /**
     * 查询所有员工
     * @return
     */
    @ApiOperation("查询所有员工")
    @RequestMapping("/selectAllStaff")
    public List<Company> selectAllStaff(){
        return companyService.selectAllStaff();
    }

    /**
     * 新增员工
     * @return
     */
    @ApiOperation("新增员工")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  insertStaff(@RequestBody Company company){
        int id = company.getId();
        List<Company> list = companyService.selectAllStaffById(id);
        if(list.isEmpty()){
            return companyService.insertStaff(company);
        }
        return "id已经存在";

    }

    /**
     * 修改
     */
    @ApiOperation("修改员工信息")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateStaffById(@RequestBody Company company){
        int id = company.getId();
        List<Company> list = companyService.selectAllStaffById(id);
        if(list.isEmpty()){
            return "id不存在，修改失败";
        }
        return companyService.updateStaffById(company);
    };

    /**
     * 批量删除
     */
    @ApiOperation("批量删除员工信息")

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("ids") List<Integer> ids){
        return companyService.delete(ids);
    };
}
