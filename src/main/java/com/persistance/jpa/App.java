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
		User user = new User();
		manager.persist(user);
		manager.getTransaction().commit();
		manager.close();
	}
}
