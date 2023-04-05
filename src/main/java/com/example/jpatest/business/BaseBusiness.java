package com.example.jpatest.business;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.database.entity.Employee;
import com.example.jpatest.database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class BaseBusiness {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee findById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent()){
            throw new IllegalStateException("Employee does not exist!");
        }
        return employee.get();
    }
    public BaseResponse generateDefaultResponse(Object result) {
        return new BaseResponse("00000", "SUCCESS", result);
    }

}
