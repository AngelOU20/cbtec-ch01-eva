package edu.cibertec.eva01.controller;

import edu.cibertec.eva01.model.Employee;
import edu.cibertec.eva01.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    public Employee getEmployeeById(Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    public void saveEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeService.deleteEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
    }
}
