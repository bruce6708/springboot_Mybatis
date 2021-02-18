package com.springboot.mybatis.dao;

import com.springboot.mybatis.domain.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CompanyMapper{

    List<Company> selectAllStaff();

    int insertStaff(Company company);

    List<Company> selectAllStaffById(int id);

    int updateStaffById(Company company);

    int delete(List<Integer> ids);
}
