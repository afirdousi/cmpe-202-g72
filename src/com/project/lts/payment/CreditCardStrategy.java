package com.project.lts.payment;

import com.project.lts.accounts.Member;
import com.project.lts.notification.Notification;

public class CreditCardStrategy implements PaymentStrategy {
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	private Member member;
	Notification notificationManager=new Notification();
	
	public CreditCardStrategy(Member member,String nm, String ccNum, String cvv, String expiryDate){
		this.name=nm;
		this.cardNumber=ccNum;
		this.cvv=cvv;
		this.dateOfExpiry=expiryDate;
		this.member=member;
	}
	@Override
	public void pay(int amount) {
		
		notificationManager.reset();
		notificationManager.setListener(member);
		notificationManager.setMessage(amount +" paid with credit/debit card");
		notificationManager.send();
		//System.out.println(member.getMemFname()+  amount +" paid with credit/debit card");
	}
}
