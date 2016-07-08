package com.kang.demo.demoList;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/7/2.
 */
public class Department {

    private List<Employee> employees = new ArrayList<Employee>();
    private long maxSalaryOffered;
    public void addEmployee(final Employee employee) {
        employees.add(employee);
        updateMaxSalaryOffered();
    }

    /**
     * The private method that keeps track of
     * max salary offered by this department.
     */
    private void updateMaxSalaryOffered() {
        maxSalaryOffered = 0;
        for (Employee employee : employees) {
            if(employee.getSalary() > maxSalaryOffered) {
                maxSalaryOffered = employee.getSalary();
            }
        }
    }


}
