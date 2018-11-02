package com.cg.bank.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.bank.dto.Customer;
import com.cg.bank.exception.BankException;


public class BankDaoImpl implements BankDao{
	
	EntityManager manager;
	
	public BankDaoImpl(){
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
		manager =emf.createEntityManager();
	}
	
	@Override
	public void createAccount(Customer customer){
		manager.getTransaction().begin();
		manager.persist(customer);
		manager.getTransaction().commit();		
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		manager.getTransaction().begin();
		Customer cust = manager.find(Customer.class, mobileNo);
		double amt =cust.getInitialBalance();
		amt=amt+amount;
		System.out.println(amt);
		cust.setInitialBalance(amt);
		manager.getTransaction().commit();
	}

	@Override
	public void withdraw(String mobileNo, double amount) {
		manager.getTransaction().begin();
		Customer cust = manager.find(Customer.class, mobileNo);
		double amt =cust.getInitialBalance();
		amt=amt-amount;
		System.out.println(amt);
		cust.setInitialBalance(amt);
		manager.getTransaction().commit();
		
	}

	@Override
	public double checkBalance(String mobileNo) {
		Customer cust = manager.find(Customer.class, mobileNo);
		double amt =cust.getInitialBalance();
		System.out.println(amt);
		return amt;
		
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		manager.getTransaction().begin();
		Customer cust1 = manager.find(Customer.class, sender);
		double amt1 =cust1.getInitialBalance();
		Customer cust2 = manager.find(Customer.class, reciever);
		double amt2 =cust2.getInitialBalance();
		amt1=amt1-amount;
		amt2=amt2+amount;
		cust1.setInitialBalance(amt1);
		cust2.setInitialBalance(amt2);
		manager.getTransaction().commit();
		
	}

	@Override
	public boolean validateaccount(String mobileNo) throws BankException {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		Customer customer = manager.find(Customer.class, mobileNo);
		manager.getTransaction().commit();
		if(customer == null)
		return false;
		
		return true;
	}

}
