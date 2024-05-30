package com.persistance.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;

@Entity
public class PurchaseOrder {
	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO) // Automatically generate value for id
	//@GeneratedValue(strategy=GenerationType.IDENTITY) //Easy to use but not best for performance optimization
	/*@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="purchaseorder_generator") // Sequence Generator
	@SequenceGenerator(name="purchaseorder_generator", sequenceName="purchaseorder_sequence")*/
	@GeneratedValue(strategy=GenerationType.TABLE, generator="purchaseorder_generator")
	@TableGenerator(name="purchaseorder_generator", table="order_table") // Table generator is deprecated
	
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
