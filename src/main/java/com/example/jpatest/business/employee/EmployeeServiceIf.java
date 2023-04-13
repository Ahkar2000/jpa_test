package com.example.jpatest.business.employee;

import com.example.jpatest.database.entity.Employee;
import java.util.List;

public interface EmployeeServiceIf {
    public List<Employee> getEmployee();
    public Employee save(Employee employee);
    public void deleteById(Long id);
    public Employee getEmployeeById(Long id);

}
