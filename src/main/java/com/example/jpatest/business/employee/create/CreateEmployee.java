package com.example.jpatest.business.employee.create;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.business.employee.EmployeeService;
import com.example.jpatest.business.employee.create.dto.EmployeeRequest;
import com.example.jpatest.database.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateEmployee extends BaseBusiness implements CreateEmployeeIf {
    @Autowired
    EmployeeService employeeService;
    public BaseResponse saveEmployee(EmployeeRequest employeeRequest){
        if(checkEmailDuplicate(employeeRequest.getEmail(),null)){
            throw new IllegalStateException("Email already exists!");
        }
        Employee employee = (Employee) changeRequest(employeeRequest);
        employeeService.save(employee);
        return generateDefaultResponse(employee);
    }
}
