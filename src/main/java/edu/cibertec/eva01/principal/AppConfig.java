package edu.cibertec.eva01.principal;

import edu.cibertec.eva01.controller.EmployeeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.cibertec.eva01")
public class AppConfig {

    @Bean
    public EmployeeController myEmployeeController(){
        return new EmployeeController();
    }
}
