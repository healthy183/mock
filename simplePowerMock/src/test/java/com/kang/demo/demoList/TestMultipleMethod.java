package com.kang.demo.demoList;

import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

/**
 * Created by Administrator on 2016/6/22.
 */
public class TestMultipleMethod {

    @Test
    public void mainTest(){
        Employee employee =  PowerMockito.mock(Employee.class);
        PowerMockito.when(employee.isNew()).thenReturn(true);
        EmployeeService employeeService = new EmployeeService();//
        employeeService.saveEmployee(employee);
        Mockito.verify(employee).create();//验证调用了create方法。
        Mockito.verify(employee,Mockito.never()).update();//验证没有调用update方法。
    }
}
