package com.persistance.jpa;

import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
    	EntityManager manager = factory.createEntityManager();
    	manager.getTransaction().begin();
    	OrderItem orderItem = new OrderItem();
    	PurchaseOrder purchaseOrder = new PurchaseOrder();
    	
    	orderItem.setId(12);
    	orderItem.setArticle("Test");
    	orderItem.setQuantity("2lb");
    	purchaseOrder.setAmount(20000);
    	purchaseOrder.setCustomername("John");
    	purchaseOrder.setId(200);
    	manager.persist(purchaseOrder);
    	manager.persist(orderItem);
    	manager.getTransaction().commit();
    	manager.close();
    }	
}
