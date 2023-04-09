package com.example.jpatest.business.employee.create;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.business.employee.EmployeeService;
import com.example.jpatest.business.employee.create.dto.EmployeeRequest;
import com.example.jpatest.database.entity.Address;
import com.example.jpatest.database.entity.Department;
import com.example.jpatest.database.entity.Employee;
import com.example.jpatest.database.repository.AddressRepository;
import com.example.jpatest.database.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CreateEmployee extends BaseBusiness implements CreateEmployeeIf {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeService employeeService;
    public BaseResponse saveEmployee(EmployeeRequest employeeRequest){
        Address address = addressRepository.findById(employeeRequest.getAddressId())
                .orElseThrow(()-> new IllegalStateException("Address id does not exist."));
        Department department = departmentRepository.findById(employeeRequest.getDepartmentId())
                .orElseThrow(()-> new IllegalStateException("Department id does not exist."));
        if(checkEmailDuplicate(employeeRequest.getEmail(),null)){
            throw new IllegalStateException("Email already exists!");
        }

        Employee employee = (Employee) changeEmployeeRequest(employeeRequest,address,department);
        employeeService.save(employee);
        return generateDefaultResponse(employee);
    }
}
