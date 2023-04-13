package com.example.jpatest.business.employee.inquiry;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.business.employee.EmployeeService;
import com.example.jpatest.database.entity.Employee;
import com.example.jpatest.database.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class InquiryEmployee extends BaseBusiness implements InquiryEmployeeIf{
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public BaseResponse getEmployee(){
        return generateDefaultResponse(employeeService.getEmployee());
    }

    @Override
    public BaseResponse getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent()){
            throw new IllegalStateException("Employee does not exists.");
        }
        return generateDefaultResponse(employeeService.getEmployeeById(id));
    }
}
