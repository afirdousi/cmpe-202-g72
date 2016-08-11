package com.project.lts.scheduler;

import java.util.List;

import com.project.lts.routing.Vertex;

public class ScheduledRide implements ScheduledRideInterface {
	
	/*String  requestId;
	Vehicle vehicle;
	Member rider;
	Member driver;
	String rideState;*/

	State state;
	
	public ScheduledRide(){
		System.out.println("Initializing Ride with WAIT state");
		state= new WaitState(this);
	}
	
	public void receiveRequest(int source, int destination){
		state.receiveRequest(source, destination);
	}
	
	public List<List<Vertex>> calculateRide(int source, int destination){
		return state.calculateRide(source,destination);
	}
	public void dispatchRide(List<List<Vertex>> suggestedRoutes){
		state.dispatchRide(suggestedRoutes);
	}
	
	public void setState(State s){
		state=s;
	}
	
	public State getState(){
		return state;
	}
	
	public void sendNotification(/*rider_id,driver_id,system,message*/){}
	
	public void completeRide(){}		//Notify System about ride completion

	
	
	

}
