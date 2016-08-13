package com.project.lts.scheduler;
import com.project.lts.accounts.*;
import com.project.lts.vehicle.*;

public class Ride {
	
	String ID; 
	//String type; //Remove it from the doc as well
	String source;
	String destination;
	ScheduledRide route; //Change route type to ScheduleRide
	Vehicle vehicle; //Change it to doc from int type to Vehicle type
	Member customer;
	
	String  riderFeedback;
	String  riderRating;
	
	String  driverFeedback;
	String  currentLocation;
	int rideAmount;

	public Ride(String ID, String source, String destination, /*ScheduledRide route, Vehicle vehicle,*/ Member customer,
			String riderFeedback,String riderRating, String driveFeedback, String currentLocation) {
		
		this.ID = ID;
		this.source = source;
		this.destination = destination;
//		this.route = route;  //Define getters/setters
//		this.vehicle = vehicle; //Define getters/setters
		this.customer = customer;
		this.riderFeedback = riderFeedback;
		this.riderRating = riderRating;
		this.driverFeedback = driveFeedback;
		this.currentLocation = currentLocation;
		
		route = new ScheduledRide();
		
		
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
	
	public String getMemberName(){
		return this.customer.getMemFname();
	}
	
	public ScheduledRide getRoute(){
		return this.route;
	}

	public void setRoute(ScheduledRide route){
		this.route = route;
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
	

}
