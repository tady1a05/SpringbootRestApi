package com.toby.employeeProject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toby.employeeProject.dao.EmployeeDaoIntf;
import com.toby.employeeProject.entity.Employee;

@RestController
@RequestMapping("/api")
public class RestApi {
	@Autowired
	private EmployeeDaoIntf employeeDaoIntf;
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeDaoIntf.saveEmployee(employee);
	}
	
	@GetMapping("/employees/{employeeID}")
	public Employee getEmployeeById(@PathVariable int employeeID) {
		return employeeDaoIntf.getEmployeeById(employeeID);
	}
	
	@GetMapping("/employees")
	public ArrayList<Employee> getEmployees() {
		return employeeDaoIntf.getAllEmployees();
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeDaoIntf.saveEmployee(employee);
	}
	
	@DeleteMapping("/employees/{employeeID}")
	public String deleteEmployeeById(@PathVariable int employeeID) {
		return employeeDaoIntf.deleteEmployee(employeeID);
	}
}
