package com.springboot.mybatis.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@Alias("Company")
public class Company implements Serializable {
    private  static  final Long serialVersionUID=1L;
    private int id;
    private  String name;
    private int age;
    private String address;
    private Double salary;
}
