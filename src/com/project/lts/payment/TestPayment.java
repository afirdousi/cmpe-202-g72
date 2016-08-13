package com.project.lts.payment;

import java.io.IOException;

public class TestPayment {
	public static void main(String []args) throws IOException{
	System.out.println("Welcome to carpool system");
	//hold payment
	int rideamount =30;
	Payment objp=new Payment();
	
	
	
	objp.sendPayment(rideamount);
	
	
	}
}
