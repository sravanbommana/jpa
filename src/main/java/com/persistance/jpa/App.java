package com.persistance.jpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
	public static void update() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Professor prof5  = manager.find(Professor.class, 2);
		prof5.setFirstName("Srinivas");
		prof5.setLastName("Sharma");
		manager.getTransaction().commit();
		manager.close();
	}
    public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Professor professor = new Professor();
		App.update();
		/*professor.setFirstName("Ravi");
		professor.setLastName("Verma");
		manager.persist(professor); */
		
		// Find element
		Professor prof1 = manager.find(Professor.class, 52);
		manager.remove(prof1);
		manager.getTransaction().commit();
		manager.close();
	}
}
