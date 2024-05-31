package com.persistance.jpa;

import jakarta.persistence.Persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
    	EntityManager manager = factory.createEntityManager();
    	manager.getTransaction().begin();
    	PurchaseOrder purchaseOrder = new PurchaseOrder();
    	purchaseOrder.setAmount(20000);
    	purchaseOrder.setCustomername("John");
			purchaseOrder.setStatus(OrderStatus.completed);
    	manager.persist(purchaseOrder);
    	manager.getTransaction().commit();
    	manager.close();
    }	
}
