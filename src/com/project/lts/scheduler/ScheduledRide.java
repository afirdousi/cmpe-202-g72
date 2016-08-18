package com.project.lts.scheduler;

import java.util.List;

import com.project.lts.accounts.Member;
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
	
	public void receiveRequest(String source, String destination){
		state.receiveRequest(source, destination);
	}
	
	public List<List<Vertex>> calculateRide(String source, String destination){
		return state.calculateRide(source,destination);
	}
	public void dispatchRide(List<List<Vertex>> suggestedRoutes,int algoType){
		state.dispatchRide(suggestedRoutes,algoType);
	}
	public void completeRide(int rideAmount ,Ride completedRide){
		state.completeRide(rideAmount,completedRide);
	}
	
	
	public void setState(State s){
		state=s;
	}
	
	public State getState(){
		return state;
	}
	
	public void sendNotification(/*rider_id,driver_id,system,message*/){}
		
	

}
