package com.persistance.jpa;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		User user = manager.find(User.class, 1);
		System.out.println(user.getDlNumber());
		System.out.println(user.getVehicle().size());

		manager.close();
	}
}
