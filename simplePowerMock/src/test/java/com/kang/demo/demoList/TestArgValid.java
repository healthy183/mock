package com.kang.demo.demoList;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

/**
 * Created by Administrator on 2016/7/2.
 */
public class TestArgValid {

    @Test
    public void testValidReturn(){
        final EmployeeService employeeService = PowerMockito.mock(EmployeeService.class);
        final Employee employee = new Employee();
        PowerMockito.when(employeeService.findEmployeeByEmail
                (Mockito.startsWith("deep"))).thenReturn(employee);
        final EmployeeController employeeController = new EmployeeController(employeeService);
        Assert.assertSame(employee, employeeController.findEmployeeByEmail("deep@gitshah.com"));
        Assert.assertSame(employee, employeeController.findEmployeeByEmail("deep@packtpub.com"));
        Assert.assertNull(employeeController.findEmployeeByEmail("noreply@packtpub.com"));
    }

    @Test
    public void testNull(){
        final EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        PowerMockito.when(mock.findEmployeeByEmail(Mockito.anyString())).thenReturn(null);
        final EmployeeController employeeController = new EmployeeController(mock);
        Assert.assertNull(employeeController.findEmployeeByEmail("deep@gitshah.com"));
        Assert.assertNull(employeeController.findEmployeeByEmail("deep@packtpub.com"));
        Assert.assertNull(employeeController.findEmployeeByEmail("noreply@packtpub.com"));
    }
}
