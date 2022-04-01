package com.Tiwari.Vijay.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tiwari.Vijay.entity.Employee;
import com.Tiwari.Vijay.repo.IEmployeeRepository;
import com.Tiwari.Vijay.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public Integer saveEmployee(Employee e) {
		return repo.save(e).getEmpId();
	}

	@Override
	public void updateEmployee(Employee e) {
		repo.save(e);
	}

	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent()) 
			return opt.get();
		else 
			return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

}
