package com.project.lts.payment;

import java.util.List;

import com.project.lts.accounts.Member;

public class PaymentManager {
	
	public void proceesPayment(int rideAmount,List<Member> members){
		Payment objP=new Payment();	
		
		for (int i = 0; i < members.size(); i++)
		{
			int finalAmount=objP.computePayment(rideAmount, members.get(i).getMemRole());
			objP.setRideAmount(finalAmount);
			
			
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

}
