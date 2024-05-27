package com.persistance.jpa;

import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
    	EntityManager manager = factory.createEntityManager();
    	manager.getTransaction().begin();
    	Professor professor = new Professor();
    	professor.setFirstName("Iris");
    	professor.setLastName("Dawane");
    	professor.setId(10);
    	manager.persist(professor);
    	manager.getTransaction().commit();
    	manager.close();
    }	
}
