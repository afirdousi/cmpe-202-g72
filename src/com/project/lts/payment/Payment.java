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
		
		public void holdPayment(int amount,List<Member> members){
			setRideAmount(amount);
			for (int i = 0; i < members.size(); i++)
			{
				notificationManager.reset();
				notificationManager.setListener(members.get(i));
				notificationManager.setMessage("Hello"+members.get(i).getMemFname()+" Payment"+ amount + "is hold for ride ");
			   //System.out.println("Hello"+members.get(i).getMemFname()+" Payment"+ amount + "is hold for ride ");
		     }
		}
		
		
		
		
		
		public void showPaymentHistory(/*memberId,paymentConfirmationNumber*/){
			
		}





		public int getRideAmount() {
			return rideAmount;
		}





		public void setRideAmount(int rideAmount) {
			this.rideAmount = rideAmount;
		}

}
