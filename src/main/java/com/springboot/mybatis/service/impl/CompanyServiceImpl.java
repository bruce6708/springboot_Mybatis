package com.springboot.mybatis.service.impl;

import com.springboot.mybatis.dao.CompanyMapper;
import com.springboot.mybatis.domain.Company;
import com.springboot.mybatis.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> selectAllStaff() {
        return companyMapper.selectAllStaff();
    }

    @Override
    public String insertStaff(Company company) {
        int addResult = companyMapper.insertStaff(company);
        if(addResult == 1){
            return  "添加成功";
        }else{
            return "添加失败";
        }

    }

    @Override
    public List<Company> selectAllStaffById(int id) {
        return companyMapper.selectAllStaffById(id);
    }

    @Override
    public String updateStaffById(Company company) {
        int addResult = companyMapper.updateStaffById(company);
        if(addResult == 1){
            return  "修改成功";
        }else{
            return "修改失败";
        }
    }

    @Override
    public String delete(List<Integer> ids) {
        int addResult = companyMapper.delete(ids);
        if(addResult > 0){
            return  "删除成功";
        }else{
            return "删除失败";
        }
    }
}
