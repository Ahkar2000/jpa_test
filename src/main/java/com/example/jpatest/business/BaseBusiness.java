package com.example.jpatest.business;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.address.create.dto.AddressRequest;
import com.example.jpatest.business.department.create.dto.DepartmentRequest;
import com.example.jpatest.business.employee.create.dto.EmployeeRequest;
import com.example.jpatest.database.entity.Address;
import com.example.jpatest.database.entity.Department;
import com.example.jpatest.database.entity.Employee;
import com.example.jpatest.database.repository.DepartmentRepository;
import com.example.jpatest.database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class BaseBusiness {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public Employee findById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent()){
            throw new IllegalStateException("Employee does not exist!");
        }
        return employee.get();
    }

    public Object changeEmployeeRequest(Object object,Address address,Department department){
        EmployeeRequest employeeRequest = (EmployeeRequest) object;
        return new Employee(employeeRequest.getName(),employeeRequest.getEmail(),employeeRequest.getBirthDate(),employeeRequest.getRole(),address,department);
    }
    public boolean checkEmailDuplicate(String email,String originalEmail){
        if(email.equals(originalEmail)) return false;
        Optional<Employee> employee = employeeRepository.findEmployeeByEmail(email);
        return employee.isPresent();
    }

    public boolean checkDepartmentName(String name,String originalName){
        if(name.equals(originalName)) return false;
        Optional<Department> department = departmentRepository.findDepartmentByName(name);
        return department.isPresent();
    }

    public BaseResponse generateDefaultResponse(Object result) {
        return new BaseResponse("00000", "SUCCESS", result);
    }

    public Object changeAddressRequest(Object object){
        AddressRequest addressRequest = (AddressRequest) object;
        return new Address(addressRequest.getStreetName(),addressRequest.getHouseNumber(),addressRequest.getCityName());
    }

    public Object changeDepartmentRequest(Object object){
        DepartmentRequest departmentRequest = (DepartmentRequest) object;
        return new Department(departmentRequest.getDepartmentName());
    }
}
