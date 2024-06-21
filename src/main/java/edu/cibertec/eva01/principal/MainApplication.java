package edu.cibertec.eva01.principal;

import edu.cibertec.eva01.controller.EmployeeController;
import edu.cibertec.eva01.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        EmployeeController emp = (EmployeeController) context.getBean("myEmployeeController");

        // Crear empleado 1
        Employee emp1 = new Employee();
        emp1.setId(1L);
        emp1.setName("John Doe");
        emp1.setPosition("Developer");
        emp1.setSalary(50000);

        emp.saveEmployee(emp1);

        // Crear empleado 1
        Employee emp2 = new Employee();
        emp2.setId(2L);
        emp2.setName("Julio Ucharima");
        emp2.setPosition("Front end");
        emp2.setSalary(1000);

        emp.saveEmployee(emp2);

        // Mostrar lista de empleados
        List<Employee> employees = emp.getAllEmployees();
        System.out.println("Lista de empleados: \n" + employees);

        // Mostrar empleado por Id
        Employee employee = emp.getEmployeeById(1L);
        System.out.println("Empleado encontrado: \n" + employee);

        // Mostrar lista de empleados después de eliminar uno
        emp.deleteEmployee(emp2);
        System.out.println("Lista de empleados: \n" + employees);

        // Actualizar empleado 1
        Employee updatedEmp1 = new Employee();
        updatedEmp1.setId(1L);
        updatedEmp1.setName("John Locke");
        updatedEmp1.setPosition("Senior Developer");
        updatedEmp1.setSalary(60000);

        emp.updateEmployee(updatedEmp1);
        System.out.println("Lista de empleados: \n" + employees);

        ((ConfigurableApplicationContext)context).close();
    }
}
