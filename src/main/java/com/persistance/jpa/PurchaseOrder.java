package com.persistance.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name="purchase_order")
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="purchaseorder_generator") 
	@SequenceGenerator(name="purchaseorder_generator", sequenceName="purchaseorder_sequence")
	
	private int id;
	private double amount;
	@Column(name="customer_name")
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
