package com.project.lts.scheduler;
import java.util.List;

import com.project.lts.accounts.*;
import com.project.lts.vehicle.*;

public class Ride {
	
	String ID; 
	//String type; //Remove it from the doc as well
	String source;
	String destination;
	ScheduledRide scheduledRide; //Change route type to ScheduleRide
	Vehicle vehicle; //Change it to doc from int type to Vehicle type
	List<Member> customers;
	String rideDate;
	String  riderFeedback;
	String  riderRating;
	
	String  driverFeedback;
	String  currentLocation;
	int rideAmount;
	
	public Ride(){
		
	}

	public Ride(String ID, String source, String destination, String rideDate,/*ScheduledRide route, Vehicle vehicle,*/ List<Member> customers,
			String riderFeedback,String riderRating, String driveFeedback, String currentLocation) {
		
		this.ID = ID;
		this.source = source;
		this.destination = destination;
		this.rideDate=rideDate;
//		this.route = route;  //Define getters/setters
//		this.vehicle = vehicle; //Define getters/setters
		this.customers = customers;
		this.riderFeedback = riderFeedback;
		this.riderRating = riderRating;
		this.driverFeedback = driveFeedback;
		this.currentLocation = currentLocation;
		
		scheduledRide = new ScheduledRide();
		
		
	}
	
	public void setMembers(List<Member> customers){
		this.customers = customers;
	}
	
	public void setRideAmount(int amount){
		this.rideAmount = amount;
	}
	
	public String getID(){
		return this.ID;
	}
	
	public String getSource(){
		return this.source;
	}
	
	public String getDestination(){
		return this.destination;
	}
	
	public List<Member> getMembers(){
		return this.customers;
	}
	
	public ScheduledRide getScheduledRide(){
		return this.scheduledRide;
	}

	public void setScheduledRide(ScheduledRide route){
		this.scheduledRide = route;
	}
	
	public Vehicle getVehicle(){
		return this.vehicle;
	}
	
	public void setVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
	}
	
	public void updateRiderFeedback(String riderFeedback){
		this.riderFeedback = riderFeedback;
	}
	
	public void updateRiderRating(String riderRating){
		this.riderRating = riderRating;
	}
	
	public void updateDriverFeedback(String driverFeedback){
		this.driverFeedback = driverFeedback;
	}
	
	public void updateCurrentLocation(String vehicleCurrentLocation){
		this.currentLocation  = vehicleCurrentLocation;
	}
	
	public void setSource(String source){
		this.source=source;
	}
	
	public void setDestination(String destination){
		this.destination=destination;
	}
	
	public void setrideDate(String rideDate){
		this.rideDate=rideDate;
	}
	
	public void setID(String ID){
		this.ID=ID;
	}
	

}
