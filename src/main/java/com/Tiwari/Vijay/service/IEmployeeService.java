package com.Tiwari.Vijay.service;

import java.util.List;



import com.Tiwari.Vijay.entity.Employee;

public interface IEmployeeService {
	
	Integer saveEmployee(Employee e);
	void updateEmployee(Employee e);
	void deleteEmployee(Integer id);
	Employee getOneEmployee(Integer id);
	List<Employee> getAllEmployees();
	


}
