package com.cg.bank.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.bank.exception.BankException;
import com.cg.bank.service.BankServiceImpl;



public class TestCases {
	@Test
	public void ValidateNameTrue() throws BankException{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validateName("Rahul"));
	}
	

	@Test
	public void ValidatePhonNumberTrue() throws BankException{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validateMoileNo("9632584170"));
	}
	
	@Test
	public void ValidateAmountTrue() throws BankException{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validateAmount(100));
	}
	
	@Test 
	public void ValidateNameV2() throws BankException{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(false, bs.validateName("Rahul487"));
		assertEquals(false, bs.validateName("Rahulv@487"));
		assertEquals(false, bs.validateName("9814533"));
		assertEquals(false, bs.validateName("rahulverma"));
	}
	@Test
	public void ValidatePhoneNumber() throws BankException{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(false, bs.validateMoileNo("963258417"));
		assertEquals(false, bs.validateMoileNo("4232584170"));
		assertEquals(false, bs.validateMoileNo("844170"));
		assertEquals(false, bs.validateMoileNo("testing"));
		assertEquals(false, bs.validateMoileNo("@#%"));
	}
	
	@Test 
	public void ValidateAmount() throws BankException{
		BankServiceImpl bs = new BankServiceImpl();
		//assertEquals(false, bs.validateAmount(0));
		assertEquals(false, bs.validateAmount(-400));
	}

}
