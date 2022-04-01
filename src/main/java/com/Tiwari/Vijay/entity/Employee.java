package com.Tiwari.Vijay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emptab")
public class Employee {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eid")
	private Integer empId;
	
	@Column(name="ename")
	@NotEmpty(message="Name can not be empty")
	@Size(min = 3,max = 10,message = "Name must be 3-10 chars")
	private String empName;
	
	@Column(name="esal")
	@NotNull(message="Salary can not be empty")
	@Min(value = 1,message = "Salary must be +Ve number")
	private Double empSal;
	
	@Column(name="egen")
	@NotEmpty(message="Please choose any one Gender")
	private String empGen;
	
	@Column(name="edept")
	@NotEmpty(message="Please choose any one Dept")
	private String empDept;
	
	@Column(name="eaddr")
	@NotEmpty(message="Please Enter Address")
	private String empAddr;
	

}
