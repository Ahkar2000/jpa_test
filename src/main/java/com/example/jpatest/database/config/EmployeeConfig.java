package com.example.jpatest.database.config;

import com.example.jpatest.constants.EmployeeRole;
import com.example.jpatest.database.entity.Employee;
import com.example.jpatest.database.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
        return (args) -> {
            Employee ahkar = new Employee("Ahkar","ahkar@gmail.com", LocalDate.of(2000, Month.FEBRUARY,20), EmployeeRole.ROLE_STAFF);
            Employee thet = new Employee("Thet","thet@gmail.com", LocalDate.of(1999, Month.SEPTEMBER,24), EmployeeRole.ROLE_STAFF);
            employeeRepository.saveAll(Arrays.asList(ahkar,thet));
        };
    }
}
