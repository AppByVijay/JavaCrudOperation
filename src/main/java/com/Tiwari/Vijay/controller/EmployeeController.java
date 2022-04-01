package com.Tiwari.Vijay.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tiwari.Vijay.entity.Employee;
import com.Tiwari.Vijay.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	//1. show register page
	@GetMapping("/register")
	public String showReg(Model model) {
		model.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}
	
	//2. save employee
	@PostMapping("/save")
	public String saveData(
			@ModelAttribute @Valid Employee employee,
			Errors errors,
			Model model
			) 
	{
		if(!errors.hasErrors()) {
			Integer id = service.saveEmployee(employee);
			model.addAttribute("message", "Employee '"+id+"' is created");
			//clear form data
			model.addAttribute("employee", new Employee());
		} else {
			//re-bind to form
			model.addAttribute("employee", employee);
			
		}
		return "EmployeeRegister";
	}
	
	//3. display all employees
	@GetMapping("/all")
	public String showData(Model model) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	//4. delete employee by id
	@GetMapping("/delete")
	public String delete(
			@RequestParam Integer id
			) 
	{
		service.deleteEmployee(id);
		//response.sendRedirect("/path");
		return "redirect:all";
	}
	
	//5. show edit page
	@GetMapping("/edit")
	public String showEdit(
			@RequestParam Integer id,
			Model model
			) 
	{
		Employee e = service.getOneEmployee(id);
		model.addAttribute("employee", e);
		return "EmployeeEdit";
	}
	
	//6. do update
	@PostMapping("/update")
	public String doUpdate(
			@ModelAttribute Employee employee
			) 
	{
		service.updateEmployee(employee);
		return "redirect:all";
	}
	

}
