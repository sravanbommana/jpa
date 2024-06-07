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
		Course course1 = new Course();
		Course course2 = new Course();

		course1.setCourseName("Java");
		course1.setCourseDuration("3 Months");
		
		course2.setCourseName("Javascript");
		course2.setCourseDuration("2 Months");
		
		Student student1 = new Student();
		Student student2 = new Student();
		
		student1.setFirstName("Ravi");
		student1.setLastName("Kiran");
		
		student2.setFirstName("Ravindra");
		student2.setLastName("Kumar");
		
		List<Student> studentList = new ArrayList<Student>();
		List<Course> courseList = new ArrayList<Course>();
		
		studentList.add(student1);
		studentList.add(student2);
		
		courseList.add(course1);
		courseList.add(course2);
		
		student1.setCourse(courseList);
		course1.setStudent(studentList);
		
		student2.setCourse(courseList);
		course2.setStudent(studentList);


		manager.persist(student1);
		manager.persist(student2);
		manager.persist(course1);
		manager.persist(course2);
		
		manager.getTransaction().commit();
		manager.close();

	}
}
