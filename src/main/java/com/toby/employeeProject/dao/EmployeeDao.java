package com.toby.employeeProject.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.toby.employeeProject.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class EmployeeDao implements EmployeeDaoIntf{
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
		return employee;
		
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}

	@Override
	@Transactional
	public ArrayList<Employee> getAllEmployees() {
		Session currentSession = entityManager.unwrap(Session.class);
		ArrayList<Employee> employees = (ArrayList<Employee>) currentSession.createQuery("Select e from Employee e").getResultList();
		return employees;
	}

	@Override
	@Transactional
	public String deleteEmployee(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from Employee where id =: employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
		return "Success";
	}
	

}
