package com.persistance.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PurchaseOrder {
	@Id
	private int id;
	private double amount;
	private String customername;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}
}
