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
		manager.getTransaction().begin();
		User user = new User();
		user.setName("Ravi");
		user.setDlNumber("GDDS9776565656");
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		vehicle1.setChasisNum("UITT556567676868686");
		vehicle1.setVehicleType("Four Wheeler");
		vehicle2.setChasisNum("HFFR057656445633223");
		vehicle2.setVehicleType("Two Wheeler");
		List<Vehicle> list = new ArrayList<Vehicle>();
		list.add(vehicle2);
		list.add(vehicle1);
		// Here we don't need to persist vehicle1 and vehicle 2 because we specified CASCADE in entity class
		// This will automatically persist vehicle1 and vehicle 2
		user.setVehicle(list);
		vehicle1.setUser(user);
		vehicle2.setUser(user);
		manager.persist(user);
		manager.getTransaction().commit();
		manager.close();
	}
}
