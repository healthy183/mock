package com.kang.demo.demoList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Administrator on 2016/6/22.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Employee.class)//告诉PowerMock准备Employee类进行测试。适用于模拟final类或有final, private, static, native
public class TestInOrder {
    @Test
    public void inOrder(){
        Employee employee = PowerMockito.mock(Employee.class);
        PowerMockito.when(employee.isNew()).thenReturn(true);
        EmployeeService employeeService = new EmployeeService();
        employeeService.saveEmployee(employee);
        InOrder inOrder = Mockito.inOrder(employee);//使用Mockito.inOrder还可以验证调用的顺序
        inOrder.verify(employee).isNew();
        inOrder.verify(employee).create();
        inOrder.verify(employee,Mockito.never()).update();
    }


}
