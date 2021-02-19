package com.springboot.mybatis.controller;

import com.springboot.mybatis.domain.Company;
import com.springboot.mybatis.domain.base.Result;
import com.springboot.mybatis.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    /**
     * 查询所有员工
     * @return
     */
    @RequestMapping("/selectAllStaff")
    public List<Company> selectAllStaff(){
        return companyService.selectAllStaff();
    }

    /**
     * 新增员工
     * @return
     */
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
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("ids") List<Integer> ids){
        return companyService.delete(ids);
    };
}
