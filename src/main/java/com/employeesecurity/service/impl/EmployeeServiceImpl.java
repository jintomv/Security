package com.employeesecurity.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.employeesecurity.dao.EmployeeDao;
import com.employeesecurity.model.Employee;
import com.employeesecurity.service.EmployeeService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class EmployeeServiceImpl implements UserDetailsService, EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {
		Employee employee = employeeDao.findByUsername(empId);
		if(employee == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new User(employee.getUsername(), employee.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<>();
		employeeDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		employeeDao.delete(id);
	}

	@Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }
}
