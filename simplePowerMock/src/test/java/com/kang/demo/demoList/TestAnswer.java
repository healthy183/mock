package com.kang.demo.demoList;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;

/**
 * Created by Administrator on 2016/7/2.
 */
public class TestAnswer {

    @Test
    public void testAnswer(){
        final EmployeeService employeeService = PowerMockito.mock(EmployeeService.class);
        final Employee employee = new Employee();

        PowerMockito.when(employeeService.findEmployeeByEmail(Mockito.anyString())).then(new Answer<Employee>() {
            @Override
            public Employee answer(InvocationOnMock invocation) throws Throwable {
                final String email = (String) invocation.getArguments()[0];
                if(email == null) return null;
                if(email.startsWith("deep")) return employee;
                if(email.endsWith("packtpub.com")) return employee;
                return null;
            }
        });

        final EmployeeController employeeController = new EmployeeController(employeeService);
        Assert.assertSame(employee, employeeController.findEmployeeByEmail("deep@gitshah.com"));
        Assert.assertSame(employee, employeeController.findEmployeeByEmail("deep@packtpub.com"));
        Assert.assertNull(employeeController.findEmployeeByEmail("hello@world.com"));
    }

    @Test
    public void testOther(){

        EmployeeService employeeService = PowerMockito.mock(EmployeeService.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) {
                return 10;
            }
        });
        EmployeeController employeeController = new EmployeeController(employeeService);
        Assert.assertEquals(10, employeeController.getProjectedEmployeeCount());
    }
}
