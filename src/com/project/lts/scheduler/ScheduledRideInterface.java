package com.project.lts.scheduler;

import java.util.List;

import com.project.lts.accounts.Member;
import com.project.lts.routing.Vertex;

public interface ScheduledRideInterface {

	public State getState();
	
	public void setState(State s);

	public void receiveRequest(String source, String destination);
	
	public List<List<Vertex>> calculateRide(String source, String destination);
	
	public void dispatchRide(List<List<Vertex>> suggestedRoutes,int algoType);
	
	public void completeRide(int rideAmount ,Ride completedRide);
	
}

