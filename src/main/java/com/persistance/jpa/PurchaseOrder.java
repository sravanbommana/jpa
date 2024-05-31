package com.persistance.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchaseorder_generator")
	@SequenceGenerator(name = "purchaseorder_generator", sequenceName = "purchaseorder_sequence")

	private int id;
	private double amount;
	private String customername;
	//Annotate enum with enumerated annotation
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public OrderStatus getStatus() {
		return status;
	}

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
