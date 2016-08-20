package com.project.lts.payment;

import java.util.ArrayList;
import java.util.List;

import com.project.lts.accounts.Member;
import com.project.lts.notification.Notification;
import com.project.lts.scheduler.Ride;

public class Payment {	
		
		int rideAmount;
		Notification notificationManager=new Notification();
		
		
		public int computePayment(int amount,String  memType){				
			
			    if(memType=="PREMIER"){
			      amount=amount-10;
				  setRideAmount(amount);	
				
			    }				    
			
				return amount;
			
				
			
        }
		
		
		public void pay(PaymentStrategy paymentMethod){
			
		    
			paymentMethod.pay(getRideAmount());
			
		
	   }
		
		public int getRideAmount() {
			return rideAmount;
		}

		public void setRideAmount(int rideAmount) {
			this.rideAmount = rideAmount;
		}

}
