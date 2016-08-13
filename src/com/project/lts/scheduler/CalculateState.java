package com.project.lts.scheduler;

import java.util.*;
import com.project.lts.routing.*;


public class CalculateState implements State{

	private ScheduledRideInterface sc;
	
	public CalculateState(ScheduledRideInterface s){
		sc=s;
	}

	public void receiveRequest(String source, String destination){
		System.out.println("Request received for route : " + source + " to " + destination);
	}
	
	public List<List<Vertex>> calculateRide(String source, String destination){
		
		int sourceID, destinationID;
		List<List<Vertex>> suggestedRoutes = new ArrayList<List<Vertex>>();
		
		System.out.println("Generating Route : for trip : " + source + " to " + destination);
		
		Route1 r1 = new Route1();		
		
		switch(source){
			case "SJC":sourceID=0; break;
			case "MTV":sourceID=1; break;
			case "RWC":sourceID=2; break;
			case "SNB":sourceID=3; break;
			case "SFO":sourceID=4; break;
			default:sourceID= -1;break;
		}
		
		switch(destination){
			case "SJC":destinationID=0; break;
			case "MTV":destinationID=1; break;
			case "RWC":destinationID=2; break;
			case "SNB":destinationID=3; break;
			case "SFO":destinationID=4; break;
			default:destinationID= -1;break;
		}
		
		
		suggestedRoutes.add(r1.findShortestDistance(sourceID, destinationID));
		
		Route2 r2= new Route2();		
		suggestedRoutes.add(r2.findLeastTime(sourceID, destinationID));
		
		
		
		System.out.println("Setting request state : DISPATCH");
		sc.setState(new DispatchState(sc));
		
		return suggestedRoutes;
	}
	public void dispatchRide(List<List<Vertex>> suggestedRoutes,int algoType){
		//return "Request is being processed";
	}
}
