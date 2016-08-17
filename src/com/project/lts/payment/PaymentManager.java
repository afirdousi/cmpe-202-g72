package com.project.lts.payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.project.lts.accounts.Member;
import com.project.lts.notification.Notification;

public class PaymentManager {
	
	Notification notificationManager=new Notification();
	
	
	HashMap<String, ArrayList<Integer>> objMap= new HashMap<String,ArrayList<Integer>>();
	
	public void proceesPayment(int rideAmount,List<Member> members){
		Payment objP=new Payment();	
		
		
		for (int i = 0; i < members.size(); i++)
		{
			int finalAmount=objP.computePayment(rideAmount, members.get(i).getMemRole());
			objP.setRideAmount(finalAmount);	
			String memId=members.get(i).getMemPaypalId();
			savePaymentHistory(memId,finalAmount);
			
			String paymentMode=members.get(i).getMemPrefpmt();			
			
			if(paymentMode=="CreditCard")
			{
				
				String memName=members.get(i).getMemFname();
				String cardNumber=members.get(i).getMemCreditcard();
				String cvv=members.get(i).getMemCreditCVV();
				String dateOfExpiry=members.get(i).getMemCreditexpdate();
				objP.pay(new CreditCardStrategy(members.get(i),memName, cardNumber, cvv, dateOfExpiry));
			}
			else{
				String memName=members.get(i).getMemFname();
				String mempaypalId=members.get(i).getMemPaypalId();
				objP.pay (new PaypalStrategy(members.get(i),memName, mempaypalId));
			}
			 
		    
		 
			
		}
		
		
		
		
		
		
	}
	
	//Code for holding payment
			public void holdPayment(int amount, List<Member> members){
		
				for (int i = 0; i < members.size(); i++)
				{
					notificationManager.reset();
					notificationManager.setListener(members.get(i));
					notificationManager.setMessage("Hello"+members.get(i).getMemFname()+" Payment"+ amount + "is hold for ride ");
				    notificationManager.send();
					//System.out.println("Hello"+members.get(i).getMemFname()+" Payment"+ amount + "is hold for ride ");
			     
				}
			}
			 
		//save payment history 
	public void savePaymentHistory(String memId ,int finalAmount){
		System.out.println(memId);
		if (objMap.containsKey(memId)) { 
			objMap.get(memId).add(finalAmount);
	    }else {
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        list.add(finalAmount);
	        objMap.put(memId, list);
	    }
				
				
	}
	
	//Show payment history for member individual member
	public void showIndPaymentHistory(String memId){	
		
		
		if(objMap.containsKey(memId)){
			
			List<Integer> list = objMap.get(memId);
			
			for(int i=0; i< list.size();i++){
				System.out.println("MemberID: "+ memId +" for ride "+ i+1 + " amount :"+ list.get(i));
			}
		}else{
			System.out.println("No History for this "+memId);
		}
		
		
				
	}
	
	
	//Show payment history for member individual member
		public void showAllPaymentHistory(){
			if(objMap.isEmpty()){
			
			System.out.println("No history for now");
			
			}
			else
			{
				System.out.println("Payment HIstory for all Rides");
				for (String key : objMap.keySet()) {
				
					System.out.println("For Member Id  " + key);
					showIndPaymentHistory(key);
				}
			}
			
											
		}
			

}
