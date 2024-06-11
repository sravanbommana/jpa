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
		//app.getUserByIdWithTypedQueryUsingPosition(1);
		app.getUserByIdWithTypedQueryUsingPositions();
	}
	

	
	// Example of Typed Query Positional
	public void getUserByIdWithTypedQueryUsingPosition(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		System.out.println("*****************************************************************");
		TypedQuery<User> query = manager.createQuery("SELECT u FROM User u where u.id=?1", User.class);
		query.setParameter(1, id);
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
	
	// Example of Typed Query Positional array
	public void getUserByIdWithTypedQueryUsingPositions() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		TypedQuery<User> typedQuery = manager.createQuery("SELECT u FROM User u where id IN ?1", User.class);
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("52");
		typedQuery.setParameter(1, list);
		List<User> user = typedQuery.getResultList();
		user.forEach(ele -> {
			System.out.println(ele.getName());
			System.out.println(ele.getDlNumber());
			List<Vehicle> list1 = ele.getVehicle();
			list1.forEach(vehicle -> System.out.println(vehicle.getVehicleType()));
		});
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.clear();
	}

	
}
