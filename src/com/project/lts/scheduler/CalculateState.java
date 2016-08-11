package com.project.lts.scheduler;

import java.util.*;
import com.project.lts.routing.*;

public class CalculateState implements State{

	private ScheduledRideInterface sc;
	
	public CalculateState(ScheduledRideInterface s){
		sc=s;
	}

	public void receiveRequest(int source, int destination){
		System.out.println("Request received for route : " + source + " to " + destination);
	}
	
	public List<List<Vertex>> calculateRide(int source, int destination){
		
		 List<List<Vertex>> suggestedRoutes = new ArrayList<List<Vertex>>();
		
		System.out.println("Generating Route : for trip : " + source + " to " + destination);
		
		Route1 r1 = new Route1();		
		suggestedRoutes.add(r1.findShortestDistance(source, destination));
		
		Route2 r2= new Route2();		
		suggestedRoutes.add(r2.findLeastTime(source, destination));
		
		
		
		System.out.println("Setting request state : DISPATCH");
		sc.setState(new DispatchState(sc));
		
		return suggestedRoutes;
	}
	public void dispatchRide(List<List<Vertex>> suggestedRoutes){
		//return "Request is being processed";
	}
}
