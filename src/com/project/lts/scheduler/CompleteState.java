package com.project.lts.scheduler;
import java.util.*;

import java.util.List;

import com.project.lts.accounts.Member;
import com.project.lts.payment.PaymentManager;
import com.project.lts.routing.*;
import com.project.lts.routing.Vertex;

public class CompleteState implements State{

	private ScheduledRideInterface sc;
	PaymentManager paymentManager ;
	
	
	public CompleteState(ScheduledRideInterface s){
		sc=s;
		paymentManager = new PaymentManager();
	}

	public void receiveRequest(String source, String destination){
		//System.out.println("Request received for route : " + source + " to " + destination);
	}
	
	public List<List<Vertex>> calculateRide(String source, String destination){
		return null;
	}
	public void dispatchRide(List<List<Vertex>> suggestedRoutes,int algoType){
		//return null;
	}
	
	public void completeRide(int rideAmount ,List<Member> members){
		
		paymentManager.proceesPayment(rideAmount, members);
		
	}
	
}
