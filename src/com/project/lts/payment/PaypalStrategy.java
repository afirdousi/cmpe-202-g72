package com.project.lts.payment;
import com.project.lts.accounts.Member;
import com.project.lts.notification.Notification;

//Changed 8/13/2016
public class PaypalStrategy implements PaymentStrategy {
	private String emailId;
	private String password;
	private Member member;
	Notification notificationManager=new Notification();
	
	public PaypalStrategy(Member member,String email, String pwd){
		this.emailId=email;
		this.password=pwd;
		this.member=member;
	}
	
	@Override
	public void pay(int amount) {
		
		notificationManager.reset();
		notificationManager.setListener(member);
		notificationManager.setMessage(amount +" paid with Paypal");
		notificationManager.send();
		//System.out.println(member.getMemFname()+amount + " paid using Paypal111.");
	}

}
