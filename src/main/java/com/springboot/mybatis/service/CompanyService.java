package com.springboot.mybatis.service;

import com.springboot.mybatis.domain.Company;

import java.util.List;

public interface CompanyService {
    List<Company> selectAllStaff();
    String insertStaff(Company company);
    List<Company> selectAllStaffById(int id);
    String updateStaffById(Company company);
    String  delete(List<Integer> ids);
}
