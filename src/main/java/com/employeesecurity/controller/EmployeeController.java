package com.employeesecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import com.employeesecurity.model.Employee;
import com.employeesecurity.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="/employee", method = RequestMethod.GET)
    public List<Employee> listUser(){
    	
//    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    	String name = user.getUsername(); //get logged in username
//    	String password = user.getPassword();
//        List<Employee> findAll = employeeService.findAll();
//        List<Employee> empList = new ArrayList<Employee>();
//        for(Employee emp : findAll)
//        {
//        	emp.setContextName(name);
//        	emp.setContextPassword(password);
//        	empList.add(emp);
//        	//findAll.add(emp.getDTO());
//        }
		return employeeService.findAll();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        employeeService.delete(id);
        return "success";
    }
}
