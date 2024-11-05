package com.skyros.demo.vo;


import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;


@Getter
@Setter
public class EmployeeVO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal salary;

}


