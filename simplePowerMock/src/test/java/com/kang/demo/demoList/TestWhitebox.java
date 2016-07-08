package com.kang.demo.demoList;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/2.
 */
public class TestWhitebox {

    @Test
    public void getInternalState(){
        final Department department = new Department();
        final Employee employee = new Employee();
        department.addEmployee(employee);
        final List<Employee> employees = Whitebox.getInternalState(department, "employees");
        Assert.assertTrue(employees.contains(employee));
    }

    @Test
    public void setInternalState() {
        final Department department = new Department();
        final Employee employee = new Employee();
        final ArrayList<Employee> employees = new ArrayList<Employee>();
        Whitebox.setInternalState(department, "employees", employees);
        department.addEmployee(employee);
        Assert.assertTrue(employees.contains(employee));
    }

    @Test
    public void invokeMethod() throws Exception {
        final Department department = new Department();
        final Employee employee1 = new Employee();
        final Employee employee2 = new Employee();
        employee1.setSalary(60000);
        employee2.setSalary(65000);
        //Adding two employees to the test employees list.
        final ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(employee1);
        employees.add(employee2);
        Whitebox.setInternalState(department, "employees", employees);
        Whitebox.invokeMethod(department,"updateMaxSalaryOffered");
        final long maxSalary = Whitebox.getInternalState(department, "maxSalaryOffered");
        Assert.assertEquals(65000, maxSalary);
    }
}
