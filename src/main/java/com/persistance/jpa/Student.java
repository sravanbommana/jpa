package com.persistance.jpa;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
	@SequenceGenerator(name = "student_generator", sequenceName = "student_sequence")
	private int id;
	private String firstName;
	private String lastName;
	@ManyToMany(mappedBy="student")
	private List<Course> course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
}
