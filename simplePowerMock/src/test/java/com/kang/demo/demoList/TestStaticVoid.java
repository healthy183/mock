package com.kang.demo.demoList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Administrator on 2016/6/22.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Employee.class)//告诉PowerMock准备Employee类进行测试。适用于模拟final类或有final, private, static, native
public class TestStaticVoid {

    @Test
    //@PrepareForTest(Employee.class)
    public  void mainTest(){
        PowerMockito.mockStatic(Employee.class);
        PowerMockito.doNothing().when(Employee.class);
        Employee.giveIncrementOf(9);
        EmployeeService employeeService = new EmployeeService();
        employeeService.giveIncrementToAllEmployeesOf(9);
        PowerMockito.verifyStatic();
        Employee.giveIncrementOf(9);
    }


}
