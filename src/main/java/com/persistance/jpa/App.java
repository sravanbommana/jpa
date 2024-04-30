package com.persistance.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    	EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Persist a new Professor
		Professor prof = new Professor();
		prof.setId(1L);
		prof.setFirstName("Jane");
		prof.setLastName("Doe");
		em.persist(prof);

		em.getTransaction().commit();
		em.close();

		em = emf.createEntityManager();
		em.getTransaction().begin();

		// Execute a query
		TypedQuery<Professor> q = em.createQuery(
				"SELECT p FROM Professor p WHERE p.firstName = :fname",
				Professor.class);
		q.setParameter("fname", "Jane");
		prof = q.getSingleResult();

		// Update the entity
		prof.setFirstName("Marie");

		em.getTransaction().commit();
		em.close();
    }
}
