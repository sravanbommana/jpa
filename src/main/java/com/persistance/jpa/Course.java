package com.persistance.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_generator")
	@SequenceGenerator(name="course_generator", sequenceName="course_sequence")
	private int id;
	private String name;
	private String duration;
	@ManyToOne
    @JoinColumn(name="professor_id")
	private Professor professor;

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
