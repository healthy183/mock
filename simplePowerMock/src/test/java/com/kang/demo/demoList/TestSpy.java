package com.kang.demo.demoList;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;

/**
 * Created by Administrator on 2016/7/2.
 */
public class TestSpy {
    //spy只能使用PowerMockito.doNothing()/doReturn()/doThrow()
    @Test
    public void mainTest(){
        final EmployeeService employeeService = PowerMockito.spy(new EmployeeService());
        final Employee employeeMock = PowerMockito.mock(Employee.class);
        PowerMockito.when(employeeMock.isNew()).thenReturn(true);
        PowerMockito.doNothing().when(employeeService).createEmployee(employeeMock);
        employeeService.saveSpy(employeeMock);
        Mockito.verify(employeeService).createEmployee(employeeMock);
    }


}
