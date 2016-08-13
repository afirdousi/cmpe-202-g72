package com.project.lts.payment;

public class PaypalStrategy implements PaymentStrategy {
	private String emailId;
	private String password;
	
	public PaypalStrategy(String email, String pwd){
		this.emailId=email;
		this.password=pwd;
	}
	
	@Override
	public void pay(int amount) {
		/*String message=amount +" paid using Paypal";
		Notification n=new Notification();
		n.setMessage(message);
		n.send();*/
		System.out.println(amount + " paid using Paypal.");
	}

}
