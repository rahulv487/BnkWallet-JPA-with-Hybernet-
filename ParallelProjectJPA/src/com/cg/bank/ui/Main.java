package com.cg.bank.ui;

import java.util.Scanner;

import com.cg.bank.dto.Customer;
import com.cg.bank.exception.BankException;
import com.cg.bank.service.BankService;
import com.cg.bank.service.BankServiceImpl;


public class Main {
	public static void main(String args[]) throws BankException{
		
		BankService service = new BankServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		
		String name, mobileNo;
		float age;
		double amount = 0;
		int ch = 0;
		do{
			System.out.println("1.Add Customer\n2.Deposit amount\n3.Withdraw Amount\n4.Fund transfer\n5.Check balance\n6.Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			Customer customer;
			switch(ch){
				case 1 :	// entering customer details				
						do{
							do{
							System.out.println("Enter customer name : ");
							name = sc.next();
							if(service.validateName(name))
								break;
							}while(true);
							
							do{
							System.out.println("Enter mobile no. : ");
							mobileNo = sc.next();
							if(service.validateMoileNo(mobileNo))
								break;
							}while(true);
							do{
							System.out.println("Enter age : ");
							age = sc.nextFloat();
							if(service.validateAge(age))
								break;
							}while(true);
							do{
							System.out.println("Enter initial amount : ");
							amount = sc.nextDouble();
							if(service.validateAmount(amount))
								break;
							}while(true);
							break;
							
						}while(true);
						
						customer = new Customer();
						customer.setName(name);
						customer.setMobileNo(mobileNo);
						customer.setAge(age);
						customer.setInitialBalance(amount);
						service.createAccount(customer);
						System.out.println("Account Added in Database....");
						break;
						
			
					
				case 2 : 	// depositing the amount
						do{
							System.out.println("Enter your mobile number : ");
							mobileNo = sc.next();
							System.out.println("Enter the amount you want to deposit");
							amount = sc.nextDouble();
							if(service.validateMoileNo(mobileNo) && service.validateAmount(amount) && service.validateaccount(mobileNo))
							{
								break;
								
							}
							else
							{
								System.out.println("Mobile number not present in the DataBase");
							}
						}while(true);
						
						service.deposit(mobileNo, amount);		
					
						break;
					
				case 3 :	// withdraw the amount
						do{
							System.out.println("Enter your mobile number : ");
							mobileNo = sc.next();
							if(service.validateMoileNo(mobileNo) && service.validateaccount(mobileNo))
								break;
							else
							{
								System.out.println("Mobile number not present in the DataBase");
							
							}
							System.out.println("Enter the amount you want to withdraw : ");
							amount = sc.nextDouble();
							if(service.validateMoileNo(mobileNo) && service.validateAmount(amount)){

								break;
							}
							
						}while(true);	
					service.withdraw(mobileNo, amount);
						
					break;
				
				case 4 ://fund trans
						String mobileNoReciever;
						do{
							System.out.println("Enter your mobile number : ");
							mobileNo = sc.next();
							
							System.out.println("Enter the amount you want to transfer : ");
							amount = sc.nextDouble();
							
							System.out.println("Enter receivers mobile number : ");
							mobileNoReciever = sc.next();
							if(service.validateMoileNo(mobileNo) && service.validateMoileNo(mobileNoReciever) && service.validateAmount(amount)&& service.validateaccount(mobileNo)){
									if(!mobileNo.equals(mobileNoReciever))
										break;
									else
										System.out.println("Sender and receiver mobile number cannot be same.");
								}
							else
							{
								System.out.println("Mobile number not present in the DataBase");
							}
						}while(true);
					service.fundTransfer(mobileNo, mobileNoReciever, amount);
					
					break;
					
				case 5 :	// check balance
						do{
							System.out.println("Enter the moible number to check balance");
							mobileNo = sc.next();
							if(service.validateMoileNo(mobileNo)&& service.validateaccount(mobileNo))
								break;
							else
							{
								System.out.println("Mobile number not present in the DataBase");
							}
						}
						
						while(true);
						
						System.out.println("Current Amount " + service.checkBalance(mobileNo));
						
					break;
					
				case 6 :
						System.out.println("Thank you for using our bank....\n......Visit again......");
					break;
					
				default : System.out.println("Invalid input! Please check again...");
			}
			
		}while(ch != 6);
		sc.close();
		
	}
}
