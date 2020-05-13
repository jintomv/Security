package com.employeesecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    @Column
    private long salary;
    @Column
    private int age;
    
    @Transient
    private String contextName;
    @Transient
    private String contextPassword;
    
    
    public String getContextPassword() {
		return contextPassword;
	}
	public void setContextPassword(String contextPassword) {
		this.contextPassword = contextPassword;
	}
	Employee()
    {
    	
    }
    Employee(String username,String password,long salary,int age,String contextName,String contextPassword)
    {
    	this.username = username;
    	this.password=password;
    	this.salary=salary;
    	this.age = age;
    	this.contextName = contextName;
    	this.contextPassword = contextPassword;
    }

	public String getContextName() {
		return contextName;
	}

	public void setContextName(String contextName) {
		this.contextName = contextName;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
//    public Employee getDTO()
//    {
//    	Employee emp = new Employee();
//		
//    	try
//		{
//			emp.setUsername(username);
//			emp.setContextName(contextName);
//			emp.setSalary(salary);
//			emp.setAge(age);
//		}
//    	catch(Exception e)
//    	{
//    		e.printStackTrace();
//    	}
//    	return emp;
//    }
}
