package com.toby.employeeProject.dao;

import java.util.ArrayList;

import com.toby.employeeProject.entity.Employee;

public interface EmployeeDaoIntf {
	public Employee saveEmployee(Employee employee);
	public Employee getEmployeeById(int id);
	public ArrayList<Employee> getAllEmployees();
	public String deleteEmployee(int id);
}
