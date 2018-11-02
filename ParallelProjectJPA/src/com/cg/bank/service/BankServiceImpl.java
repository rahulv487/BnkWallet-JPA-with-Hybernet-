package com.cg.bank.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.bank.dao.BankDao;
import com.cg.bank.dao.BankDaoImpl;
import com.cg.bank.dto.Customer;
import com.cg.bank.exception.BankException;


public class BankServiceImpl implements BankService{
	BankDao dao;
	
	public BankServiceImpl() throws BankException {
		dao = new BankDaoImpl();
	}
	
	@Override
	public void createAccount(Customer customer) {
		dao.createAccount(customer);	
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		dao.deposit(mobileNo, amount);
	}

	@Override
	public void withdraw(String mobileNo, double amount) {
		dao.withdraw(mobileNo, amount);
	}

	@Override
	public double checkBalance(String mobileNo) {
		return dao.checkBalance(mobileNo);
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		dao.fundTransfer(sender, reciever, amount);
		
	}
	
	public boolean validateName(String name) throws BankException {		//Checking for valid name
		if(name == null)
			throw new BankException("Null value found");
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{2,10}");
		Matcher m = p.matcher(name); 
		if(!m.matches())
			System.out.println("Invalid name entered-- Name should start with a capital letter and should contain only alphabets");
		return m.matches();	
	}

	@Override
	public boolean validateAge(float age)  throws BankException {		//Checking for valid age
		try{
			if(age == 0)
				System.out.println("Age cannot be  zero");
			else if(age >100)
				System.out.println("Age cannot be  greater than 100");
			else if(age < 0)
				System.out.println("Age cannot be negative");
			else if(age <=17)
				System.out.println("Not eligible-Minimum age to open account is 18");
			else if(age >17)
				return true;
	} catch (Exception e) {
		System.out.println(e);
	}
		return false;
	}

	@Override
	public boolean validateMoileNo(String mobileNo) throws BankException{		//Checking for valid mobile number
		try{
			if(mobileNo == null)
				throw new BankException("Null value found");
			Pattern p = Pattern.compile("[6789][0-9]{9}");
			Matcher m = p.matcher(mobileNo);
			if(!m.matches())
				System.out.println("Mobile Number Invalid-Please enter a valid Mobile Number (6-9) of 10 digits");
			return m.matches();
	} catch (BankException e) {
		System.out.println(e);
	}
		return false;
	}

	@Override
	public boolean validateAmount(double amount) throws BankException {			//Checking for valid transaction amount
		try{
			if(amount == 0)
				throw new BankException("Initial deposit amount can not be zero-Please deposit some amount...");
			String am = String.valueOf(amount);
			if(!am.matches("\\d{0,9}\\.\\d{0,3}"))
				System.out.println("Invalid Amount entered-Please enter a valid numeric value");
			return (am.matches("\\d{0,9}\\.\\d{0,}"));
		}catch(BankException e){
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean validateaccount(String mobileNo) throws BankException {
		// TODO Auto-generated method stub
		return dao.validateaccount(mobileNo);
	}

	/*@Override
	public boolean validateAccount(String mobileNo) throws BankException {		
		return dao.validateAccount(mobileNo);	
	}*/

}
