package com.skyros.demo.controller;

import com.skyros.demo.service.EmployeeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Setter
@Getter
@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public void createRandomEmployee() {
        getEmployeeService().createRandomEmployee();
    }

    @PostMapping("/message/{message}")
    public void sendMessage(@PathVariable String message) {
        getEmployeeService().sendMessage(message);
    }

}
