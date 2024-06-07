package com.persistance.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private int id;
	private String firstName;
	private String lastName;

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
	
	@PrePersist
	public void logNewUserAttempt() {
	    System.out.println("Attempting to add new user with username: " + firstName);
	}
	    
	@PostPersist
	public void logNewUserAdded() {
		 System.out.println("Added user '" + firstName + "' with ID: " + id);
	}
	
	@PreRemove
	public void logUserRemovalAttempt() {
		System.out.println("Attempting to delete user: " + firstName);
	}
	    
	@PostRemove
	public void logUserRemoval() {
		System.out.println("Deleted user: " + firstName);
	}

	@PreUpdate
	public void logUserUpdateAttempt() {
		System.out.println("Attempting to update user: " + firstName);
	}

	@PostUpdate
	public void logUserUpdate() {
		System.out.println("Updated user: " + firstName);
	}

	@PostLoad
	public void logUserLoad() {
	    String fullName = firstName + " " + lastName;
		System.out.println("Post load: " + fullName);

	}

}
