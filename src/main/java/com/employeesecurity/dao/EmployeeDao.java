package com.employeesecurity.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employeesecurity.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {
    Employee findByUsername(String username);
}
