package com.example.jpatest.business.employee.update;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.business.employee.EmployeeService;
import com.example.jpatest.business.employee.create.dto.EmployeeRequest;
import com.example.jpatest.database.entity.Employee;
import com.example.jpatest.database.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UpdateEmployee extends BaseBusiness implements UpdateEmployeeIf {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public BaseResponse updateEmployee(Long id,EmployeeRequest employeeRequest) {
        Employee employee = findById(id);
        if(checkEmailDuplicate(employeeRequest.getEmail(),employee.getEmail())){
            throw new IllegalStateException("Email already exists!");
        }
        employee.setName(employeeRequest.getName());
        employee.setBirthDate(employeeRequest.getBirthDate());
        employee.setRole(employeeRequest.getRole());
        employee.setEmail(employeeRequest.getEmail());
        employee = employeeService.save(employee);
        return generateDefaultResponse(employee);
    }

    @Override
    public BaseResponse deleteEmployee(Long id){
        Optional<Employee> employeeCheck = employeeRepository.findById(id);
        if(!employeeCheck.isPresent()){
            throw new IllegalStateException("Employee does not exist.");
        }
        Employee employee = employeeCheck.get();
        employeeService.deleteById(id);
        return generateDefaultResponse("Employee id "+employee.getId()+" is deleted.");
    }
}
