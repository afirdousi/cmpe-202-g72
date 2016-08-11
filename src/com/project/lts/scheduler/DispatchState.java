package com.project.lts.scheduler;
import java.util.*;

import java.util.List;

import com.project.lts.routing.Route;
import com.project.lts.routing.Vertex;

public class DispatchState implements State{

	private ScheduledRideInterface sc;
	
	public DispatchState(ScheduledRideInterface s){
		sc=s;
	}

	public void receiveRequest(int source, int destination){
		System.out.println("Request received for route : " + source + " to " + destination);
	}
	
	public List<List<Vertex>> calculateRide(int source, int destination){
		return null;
	}
	public void dispatchRide(List<List<Vertex>> suggestedRoutes){
		
		System.out.println("Ride ready for dispatch");
		System.out.println("Select one route \n\n \t [1]Least Distance	[2]Least Cost");  // Need to fix this menu
		Scanner selectedRoute = new Scanner(System.in);
		System.out.println();
		int selection = selectedRoute.nextInt();
		
		if(selection == 1){
			System.out.println(suggestedRoutes.get(0));
		}
		
		if(selection == 2){
			System.out.println(suggestedRoutes.get(1));
		}

		selectedRoute.close();
		
		sc.setState(new WaitState(sc));
		System.out.println("Ride dispatched");
		
	}
}
