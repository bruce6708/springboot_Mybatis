package com.springboot.mybatis;

import com.springboot.mybatis.dao.CompanyMapper;
import com.springboot.mybatis.domain.Company;
import com.springboot.mybatis.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyMapper companyMapper;

    @Test
    void insert() {
        Company company = new Company();
        company.setId(5);
        company.setName("Lili5");
        company.setAge(20);
        company.setAddress("南京");
        company.setSalary((double) 12333);
        String result = companyService.insertStaff(company);
        System.out.println(result);
    }
    @Test
    void delete() {
        List<Integer> list = new ArrayList();
        list.add(4);
        list.add(5);
        int result = companyMapper.delete(list);
        System.out.println(result);
    }
}
