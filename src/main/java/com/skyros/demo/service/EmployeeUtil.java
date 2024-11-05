package com.skyros.demo.service;


import com.skyros.demo.vo.EmployeeVO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Getter
@Setter
@Service
public class EmployeeUtil {

    private final String names[] = {"Ahmed", "Ali", "Hassan", "Mohamed", "Said", "Saad", "Mostafa", "Ibrahim"};
    private final String mail[] = {"stc.com", "gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "skyros.com", "demo.com", "tesla.com"};
    private final BigDecimal salary[] = {BigDecimal.valueOf(5000), BigDecimal.valueOf(6000), BigDecimal.valueOf(7000), BigDecimal.valueOf(8000), BigDecimal.valueOf(9000), BigDecimal.valueOf(10000), BigDecimal.valueOf(11000), BigDecimal.valueOf(12000)};
    private int max = 7;
    private int min = 0;
    private long sleep;

    public EmployeeVO createRandomEmployee() {
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setFirstName(names[getRandomIndex()]);
        employeeVO.setLastName(names[getRandomIndex()]);
        StringBuilder email = new StringBuilder(employeeVO.getFirstName()).append(".")
                .append(employeeVO.getLastName())
                .append("@").append(mail[getRandomIndex()]);
        employeeVO.setEmail(email.toString().toLowerCase(Locale.ROOT));
        employeeVO.setSalary(salary[getRandomIndex()]);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return employeeVO;
    }

    public List<EmployeeVO> getEmployeeList(int size) {
        List<EmployeeVO> employeeVOList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            employeeVOList.add(createRandomEmployee());
        }
        return employeeVOList;
    }

    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private int getRandomId() {
        Random rand = new Random();
        return rand.nextInt(10000);
    }

}
