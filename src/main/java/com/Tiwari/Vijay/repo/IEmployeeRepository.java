package com.Tiwari.Vijay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Tiwari.Vijay.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	
	

}
