package com.kang.demo.demoList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Administrator on 2016/6/22.
 */
@RunWith(PowerMockRunner.class)
public class TestFinal {

    @Test
    @PrepareForTest(EmployeeService.class)
    public void mainTest(){
       // EmployeeService employeeService = PowerMockito.mock(EmployeeService.class);
        //Employee employee = new Employee();
       // Employee employee = PowerMockito.mock(Employee.class);
       // PowerMockito.when(employee.isNew()).thenReturn(true);
        //PowerMockito.when(employee.setEmployeeId(new Object())).thenReturn(true);
        //EmployeeIdGenerator employeeIdGenerator = PowerMockito.mock(EmployeeIdGenerator.class);
        //PowerMockito.doNothing().when(employeeIdGenerator).getNextId();

        //EmployeeService employeeService = new EmployeeService();
        //PowerMockito.when(employeeService.isNew()).thenReturn(true);


        EmployeeService employeeService = PowerMockito.mock(EmployeeService.class);
        EmployeeController employeeController = new EmployeeController(employeeService);
        Employee employee = new Employee();

        employeeController.saveWithId(employee);
        Mockito.verify(employeeService).saveWithFinalMethod(employee);
    }
}
