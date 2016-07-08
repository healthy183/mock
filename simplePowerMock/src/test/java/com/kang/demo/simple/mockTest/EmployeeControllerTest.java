package com.kang.demo.simple.mockTest;

import com.kang.demo.simple.controller.EmployeeController;
import com.kang.demo.simple.domain.Employee;
import com.kang.demo.simple.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

/**
 * Created by Administrator on 2016/6/20.
 */
public class EmployeeControllerTest {

    @Test
    public void  mockgetEmployeeCount(){
        EmployeeService employeeService = PowerMockito.mock(EmployeeService.class);
        PowerMockito.when(employeeService.getEmployeeCount()).thenReturn(1);
        EmployeeController controller = new EmployeeController(employeeService);
        Assert.assertEquals(2,controller.getProjectedEmployeeCount());
    }

    @Test
    public void mockSaveEmployee(){
        EmployeeService employeeService = PowerMockito.mock(EmployeeService.class);
        EmployeeController employeeController = new EmployeeController(employeeService);
        Employee employee = new Employee();
        employeeController.saveEmployee(employee);//注释本行代码将报Wanted but not invoked:错
        Mockito.verify(employeeService).saveEmployee(employee);//saveEmployee(Employee)没有返回值，我们只需要用verify确认有调用
    }
}
