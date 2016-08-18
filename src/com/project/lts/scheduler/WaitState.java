package com.project.lts.scheduler;

import java.util.List;

import com.project.lts.accounts.Member;
import com.project.lts.routing.*;
import com.project.lts.routing.Vertex;

public class WaitState implements State{
	
	private ScheduledRideInterface sc;
	
	public WaitState(ScheduledRideInterface s){
		sc=s;
	}

	public void receiveRequest(String source, String destination){
		
		System.out.println("Request received for route : " + source + " to " + destination);
		
		System.out.println("Current request state : WAIT");
		System.out.println("Setting request state : CALCULATE");
		sc.setState(new CalculateState(sc));

	}
	
	public List<List<Vertex>> calculateRide(String source, String destination){
		return null;
	}
	public void dispatchRide(List<List<Vertex>> suggestedRoutes,int algoType){
		
	}

	public void completeRide(int rideAmount ,Ride completedRide){
		
	}
}
