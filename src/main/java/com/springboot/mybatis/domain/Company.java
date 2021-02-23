package com.springboot.mybatis.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@Alias("Company")
@ApiModel("员工信息表")
public class Company implements Serializable {
    private  static  final Long serialVersionUID=1L;
    @ApiModelProperty("员工ID")
    private int id;
    @ApiModelProperty("员工姓名")
    private  String name;
    @ApiModelProperty("员工年龄")
    private int age;
    @ApiModelProperty("员工地址")
    private String address;
    @ApiModelProperty("员工工资")
    private Double salary;
}
