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
		
		//Creating Professors
		Professor professor = new Professor();
		professor.setFirstName("Srinivasa");
		professor.setLastName("Chari");
		
		//Creating Courses
		Course javaCourse = new Course();
		javaCourse.setDuration("6 months");
		javaCourse.setName("Java");
		
		Course javaScriptCourse = new Course();
		javaScriptCourse.setDuration("6 months");
		javaScriptCourse.setName("JavaScript");
		
        // Associate Courses with the Professor
		
		javaCourse.setProfessor(professor);
		javaScriptCourse.setProfessor(professor);
		
		
		professor.getCourses().add(javaScriptCourse);
		professor.getCourses().add(javaCourse);


        // Persist entities
		manager.persist(javaCourse);
		manager.persist(javaScriptCourse);
		manager.persist(professor);


		manager.getTransaction().commit();
		manager.close();
	}
}
