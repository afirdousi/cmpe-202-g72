package com.project.lts.scheduler;
import java.util.*;

import java.util.List;

import com.project.lts.accounts.Member;
import com.project.lts.payment.PaymentManager;
import com.project.lts.routing.*;
import com.project.lts.routing.Vertex;

public class DispatchState implements State{

	private ScheduledRideInterface sc;
	
	
	public DispatchState(ScheduledRideInterface s){
		sc=s;
	}

	public void receiveRequest(String source, String destination){
		System.out.println("Request received for route : " + source + " to " + destination);
	}
	
	public List<List<Vertex>> calculateRide(String source, String destination){
		return null;
	}
	public void dispatchRide(List<List<Vertex>> suggestedRoutes,int algoType){
		
		System.out.println("Ride ready for dispatch");
		
		String algoName;
		if(algoType==0){
			algoName = " Distance";
		}else{
			algoName = " Cost";
		}
		System.out.println("Algorithm Selected : Minimum" + algoName);
		
//		System.out.println("Select one route \n\n \t [1]Least Distance	[2]Least Cost");  // Need to fix this menu
		//Scanner selectedRoute = new Scanner(System.in);
//		System.out.println();
		
		
		//TODO: Define separate flavor of dispatchRide which prompts to choose the algo
//		int selection = selectedRoute.nextInt();
//		
//		if(selection == 1){
//			System.out.println(suggestedRoutes.get(0));
//		}
//		
//		if(selection == 2){
//			System.out.println(suggestedRoutes.get(1));
//		}
		
		//algoType : 0 > Least Distance , 1 > Lease Cost 
		System.out.println(suggestedRoutes.get(algoType));
		
		//selectedRoute.close();
		
		sc.setState(new CompleteState(sc));
		System.out.println("Ride dispatched");
		
	}

	public void completeRide(int rideAmount ,Ride completedRide){
		
	}
	
	
}
