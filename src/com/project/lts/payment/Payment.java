package com.project.lts.payment;

public class Payment {
	//ScheduledRide rideDetails;//to get ride information
		int rideAmount;
		String coupon;
		String paymentConfirmationNumber;
		String payment;
		String paymentMode;
		String memberType="";
		boolean isCoupon;
		
		
		//Changed 8/13/2016
		public void sendPayment(int amount){			
			
			rideAmount=amount;						
			if(paymentMode=="paypal")
			{
			  
		      pay (new PaypalStrategy("myemail@example.com", "mypwd"));
			}
			else
			{
				
			     pay (new CreditCardStrategy("Snehal Golhar", "123466778844334", "996", "2/20"));

			}
		}

		public int computePayment(){
				
			/* need 
				 * memberType,coupon,amount,memberobject*/
			if(memberType=="Premium"){
				rideAmount=rideAmount-10;	
				
			}
			if(isCoupon==true){
				rideAmount=rideAmount-5;
			}
			
			return rideAmount;
				
			
		}
		
		public void pay(PaymentStrategy paymentMethod){
			
			
		    int amount = computePayment();			
			paymentMethod.pay(amount);
			//processPayment();
		
	   }
		
		public void holdPayment(int amount){
			System.out.println("Payment"+amount+" is hold for ride ");
		}
		
		public void notifyCustomer(){
			//code to notify user
		}
		
		public void processPayment(/*paymentDetails,paymentConfirmationNumber*/){
			if(paymentMode=="paypal")
			{
			  
		      pay (new PaypalStrategy("myemail@example.com", "mypwd"));
			}
			else
			{
				
			     pay (new CreditCardStrategy("Snehal Golhar", "123466778844334", "996", "2/20"));

			}
		}
		
		public void showPaymentHistory(/*memberId,paymentConfirmationNumber*/){
			
		}

}
