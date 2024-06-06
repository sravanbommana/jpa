package com.persistance.jpa;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
	public static void main(String args[]) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Manager manager = new Manager();
		Department department = new Department();
		department.setDeptManager("Raj Yogi");
		department.setDeptName("Finance");
		manager.setFirstName("Raj");
		manager.setLastName("Yogi");
		department.setManager(manager);
		manager.setDepartment(department);
		entityManager.persist(manager);
		entityManager.persist(department);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
