package com.kang.demo.demoList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Administrator on 2016/7/2.
 */
//@RunWith(PowerMockRunner.class)
public class TestConstructor {

    @Test
    //@PrepareForTest(EmployeeService.class)
    public void mainTest(){

        EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        EmployeeController employeeController = new EmployeeController(mock);
        Employee employee = new Employee();
        employeeController.saveWithConstructor(employee);
        Mockito.verify(mock).saveWithConstructor(employee);
    }


}
