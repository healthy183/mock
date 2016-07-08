package com.kang.demo.demoList;


/**
 * Created by Administrator on 2016/6/20.
 */
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void saveWithId(Employee employee){
        employeeService.saveWithFinalMethod(employee);
    }

    public void saveWithConstructor(Employee employee){
        employeeService.saveWithConstructor(employee);
    }

    public Employee findEmployeeByEmail(String email) {
        return employeeService.findEmployeeByEmail(email);
    }

    public boolean isEmployeeEmailAlreadyTaken(String email) {
        Employee employee = new Employee();
        return employeeService.employeeExists(employee);
    }

    public int getProjectedEmployeeCount() {
      return  employeeService.getProjectedEmployeeCount();
    }

    public void saveSpy(Employee employee){
        employeeService.saveSpy(employee);
    }
}
