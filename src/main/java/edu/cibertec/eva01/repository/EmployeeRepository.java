package edu.cibertec.eva01.repository;

import edu.cibertec.eva01.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void saveEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    public void updateEmployee(Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(updatedEmployee.getId());
        if (existingEmployee != null) {
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setPosition(updatedEmployee.getPosition());
            existingEmployee.setSalary(updatedEmployee.getSalary());
        }
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
}
