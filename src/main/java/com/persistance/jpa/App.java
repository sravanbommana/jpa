package com.persistance.jpa;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class App 
{
	//Run 1.4-cascade-entity branch to insert some data before running this 
	public static void main(String[] args) {
		App app = new App();
		//app.getUserByIdWithTypedQuery(1);
		//app.getUserByIdWithNativeQuery(52);
		app.getUserByIdWithNamedQuery(52);
	}
	
	//Example of Named Query
	public void getUserByIdWithNamedQuery(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createNamedQuery("User.findByUserID");
		query.setParameter("id", id);
		List<User> user = query.getResultList();
		user.forEach(ele -> {
			System.out.println(ele.getName());
			System.out.println(ele.getDlNumber());
			List<Vehicle> list = ele.getVehicle();
			list.forEach(vehicle -> System.out.println(vehicle.getVehicleType()));
		});
		manager.getTransaction().commit();
		manager.close();
	}

	
	//Example of Native Query
	public void getUserByIdWithNativeQuery(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query jpqlNativeQuery = manager.createNativeQuery("Select * from User where id=:id", User.class);
		jpqlNativeQuery.setParameter("id", id);
		List<User> user = jpqlNativeQuery.getResultList();
		user.forEach(ele -> {
			System.out.println(ele.getName());
			System.out.println(ele.getDlNumber());
			List<Vehicle> list = ele.getVehicle();
			list.forEach(vehicle -> System.out.println(vehicle.getVehicleType()));
		});
		manager.getTransaction().commit();
		manager.close();

	}
	
	// Example of Typed Query
	public void getUserByIdWithTypedQuery(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		System.out.println("*****************************************************************");
		TypedQuery<User> query = manager.createQuery("SELECT u FROM User u where u.id=:id", User.class);
		query.setParameter("id", id);
		List<User> user = query.getResultList();
		user.forEach(ele -> {
			System.out.println(ele.getName());
			System.out.println(ele.getDlNumber());
			List<Vehicle> list = ele.getVehicle();
			list.forEach(vehicle -> System.out.println(vehicle.getVehicleType()));
		});
		System.out.println("*****************************************************************");
		manager.getTransaction().commit();
		manager.close();
	}
}
