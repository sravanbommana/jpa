package com.persistance.jpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Employee emp = new Employee();
		emp.setFirstName("John");
		emp.setLastName("Doe");
		Address address = new Address();
		address.setCity("Richmond");
		address.setStreetName("E Varsham Rd");
		address.setZipCode("85050");
		emp.setAddress(address);
		manager.persist(emp);
		manager.getTransaction().commit();
		manager.close();
	}
}
