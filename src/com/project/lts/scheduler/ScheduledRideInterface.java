package com.project.lts.scheduler;

import java.util.List;

import com.project.lts.routing.Vertex;

public interface ScheduledRideInterface {

	public State getState();
	
	public void setState(State s);

	public void receiveRequest(int source, int destination);
	
	public List<List<Vertex>> calculateRide(int source, int destination);
	
	public void dispatchRide(List<List<Vertex>> suggestedRoutes);
	
}

