package com.example.jpatest.business.employee;

import com.example.jpatest.database.entity.Employee;
import com.example.jpatest.database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements EmployeeServiceIf{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    };
    @Override
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    };
    @Override
    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    ;

}
