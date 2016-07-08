package com.kang.demo.simple.controller;

import com.kang.demo.simple.domain.Employee;
import com.kang.demo.simple.service.EmployeeService;

/**
 * Created by Administrator on 2016/6/20.
 */
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public int getProjectedEmployeeCount() {
        final int actualEmployeeCount = employeeService.getEmployeeCount();
        return (int) Math.ceil(actualEmployeeCount * 1.2);
    }

    public void saveEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
    }

}
