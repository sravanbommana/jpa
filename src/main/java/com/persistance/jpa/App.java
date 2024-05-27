package com.persistance.jpa;

import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Hi");
    	Logger logger = LogManager.getLogger(App.class);
        logger.info("We've just greeted the user!");
    	System.out.println("Bye");
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
    	EntityManager manager = factory.createEntityManager();
    	manager.getTransaction().begin();
    	Professor professor = new Professor();
    	professor.setFirstName("ndrew");
    	professor.setLastName("Dawane");
    	professor.setId(10);
    	manager.persist(professor);
    	manager.getTransaction().commit();
    	manager.close();

    }	
}
