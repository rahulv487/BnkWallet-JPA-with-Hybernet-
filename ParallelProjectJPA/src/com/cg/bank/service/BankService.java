package com.cg.bank.service;

import com.cg.bank.dto.Customer;
import com.cg.bank.exception.BankException;


public interface BankService {
	
	public void createAccount(Customer customer);
	
	public void deposit(String mobileNo, double amount);
	
	public void withdraw(String mobileNo, double amount);
	
	public double checkBalance(String mobileNo);
	
	public void fundTransfer(String sender, String reciever, double amount);
	
//	public boolean validateAccount(String mobileNo) throws BankException;
	
	public boolean validateName(String name) throws BankException;
	
	public boolean validateAge(float age) throws BankException;
	
	public boolean validateMoileNo(String mobileNo) throws BankException;
	
	public boolean validateAmount(double amount) throws BankException;
			
	public boolean validateaccount(String mobileNo) throws BankException;			
}
