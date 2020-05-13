package com.employeesecurity.service;

import java.util.List;

import com.employeesecurity.model.Employee;

public interface EmployeeService {

    Employee save(Employee employee);
    List<Employee> findAll();
    void delete(long id);
}
