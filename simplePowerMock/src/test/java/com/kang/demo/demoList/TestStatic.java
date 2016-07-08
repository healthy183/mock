package com.kang.demo.demoList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Administrator on 2016/6/20.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Employee.class)//告诉PowerMock准备Employee类进行测试。适用于模拟final类或有final, private, static, native
public class TestStatic {

    @Test
    public void testStaticMethod(){
        PowerMockito.mockStatic(Employee.class);
        PowerMockito.when(Employee.count()).thenReturn(1);
        EmployeeService employeeService = new EmployeeService();
        Assert.assertEquals(1,employeeService.getEmployeeCount());
    }

}
