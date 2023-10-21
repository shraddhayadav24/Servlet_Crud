package com.jsp.servlet.employeedao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.servlet.employeedto.Employee;

public class EmployeeDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction=entityManager.getTransaction();

	public Employee saveEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		
		return employee;
	}
	
	public Employee getEmployeeById(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		return employee;
		
	}
	
	public boolean deleteEmployeeById(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			
			return true;
		}else {
			return false;
		}
	}
	
	public boolean updateEmployeeEmailById(int id, String email) {
		Employee employee=entityManager.find(Employee.class, id);
		employee.setEmail(email);
		entityTransaction.begin();
//		entityManager.merge(email);
		entityManager.merge(employee);
		entityTransaction.commit();
		return true;
	}
	
	public List<Employee> getall(){
		String sql="SELECT e FROM Employee e";
		Query query=entityManager.createQuery(sql);
		List<Employee> employees=query.getResultList();
		return employees;
		
		
	}
	
	
	
}
