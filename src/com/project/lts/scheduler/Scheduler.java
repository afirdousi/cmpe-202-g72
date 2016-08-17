package com.project.lts.scheduler;
import java.util.*;
import java.util.stream.Collectors;

import com.project.lts.accounts.AccountClient;
import com.project.lts.accounts.Customer;
import com.project.lts.accounts.Member;
import com.project.lts.notification.Notification;
import com.project.lts.vehicle.Vehicle;

public class Scheduler {

	public List<Ride> currentRides;
	Ride ride;
	//ArrayList<Member> customers;
	long rideCount=1;
	Notification notificationManager=new Notification();
	
	public Scheduler(){
		currentRides = new ArrayList<Ride>();
	}
	
	public void setupMockRide(List<Member> members){
		
		List<Member> customersOfCurrentRide;
		Member dummy = new Customer() ;
		for (Member m : members) {
			if(m.getMemType()=="C"){
//				customersOfCurrentRide = new ArrayList<Member>();
//				customersOfCurrentRide.add(m);
				ride  =  new Ride(Long.toString(this.rideCount),"SJC","SFO","8/20/2016",m,"","","","");
				this.currentRides.add(ride);
				this.rideCount++;
			}
			
			dummy = m;
		
		}
		
		ride  =  new Ride(Long.toString(this.rideCount),"SFO","MTV","8/20/2016",dummy,"","","","");
		this.currentRides.add(ride);
		this.rideCount++;
		
		ride  =  new Ride(Long.toString(this.rideCount),"SFO","RWC","8/20/2016",dummy,"","","","");
		this.currentRides.add(ride);
		this.rideCount++;
		
		ride  =  new Ride(Long.toString(this.rideCount),"MTV","SNB","8/20/2016",dummy,"","","","");
		this.currentRides.add(ride);
		this.rideCount++;
		
		ride  =  new Ride(Long.toString(this.rideCount),"MTV","SFO","8/20/2016",dummy,"","","","");
		this.currentRides.add(ride);
		this.rideCount++;
		
		ride  =  new Ride(Long.toString(this.rideCount),"KHI","SJC","8/20/2016",dummy,"","","","");
		this.currentRides.add(ride);
		this.rideCount++;
		
		ride  =  new Ride(Long.toString(this.rideCount),"BLR","SJC","8/20/2016",dummy,"","","","");
		this.currentRides.add(ride);
		this.rideCount++;
	}
	
	public long getTotalRideCount(){
		return this.rideCount;
	}
	
	public void addRide(Ride ride, Member currentUser){
		
		this.rideCount++;
		ride.ID=Long.toString(this.rideCount);
		this.currentRides.add(ride);
		
		notificationManager.reset();
		notificationManager.setListener(currentUser);
		notificationManager.setMessage("New Ride added to be schedueld!");
	    notificationManager.send();
				

	}
	
	public void removeRide(String rideID,Member cancellingUser){
		
		boolean rideFound = false;
//		System.out.println("In Remove Ride........");
//		System.out.println("Rides before removal");
//
//		for(Ride r:this.currentRides){
//			displayRideInfo(r);
//		}
		
		
		for(Ride r:this.currentRides){
			if(r.getID().equalsIgnoreCase(rideID)){
				rideFound = true;
				String rideIDToBeDeleted = r.getID();
				this.currentRides.remove(r);
				
				notificationManager.reset();
				notificationManager.setListener(cancellingUser);
				notificationManager.setMessage("Dear user, your ride with ID : " + rideIDToBeDeleted + " has been deleted.");
			    notificationManager.send();
			}
		}
		
		if(!rideFound){
//			System.out.println("Rides after removal........");
//	
//			for(Ride r:this.currentRides){
//				displayRideInfo(r);
//			}
			
		}else{
			System.out.println("Ride with ID:" + rideID + " not found.");
		}
		
		
	}
	
	public void displayRideInfo(Ride r){
		//TODO: Fix this
//		System.out.println("No of customer = " + r.customers.size());
//		System.out.println("Name of customer = " + r.customers.get(0).getMemFname());
		System.out.println("ID: " + r.ID + " | Source: " + r.source + " | Destination: " + r.destination + " | Date: " + r.rideDate );//+ " | Requester: " + r.customers.get(0).getMemFname());
		
	}
	
	public boolean isEligibileForCoupon(Member memberToCheck){
		
		boolean result = false;
		
		ArrayList<Ride> myRides = new ArrayList<Ride>();
		
		for (Ride ride : this.currentRides) {
				for (Member member : ride.getMembers()) {
					if(member!=null){
						if(member.getnMemberID()==memberToCheck.getnMemberID()){
							myRides.add(ride);
						}
					}
				}
		}
		
		if(myRides.size()>2){
			result = true;
		}
		
		return result;
	}

	public void carpoolRides(List<Vehicle> vehicles){
		
		//Carpooling Algo which reduces number of currentRides
		
		//ALGO: 
		//Match vehicle location to source of requested ride location && Match source among requested rides && Number of seats per vehicles should not exceed 4
		
		//Step.0 : Rides which cannot be scheduled
		boolean canBeScheduled;
		for(Ride ride:currentRides){
			
			 canBeScheduled =false;
			 
			for(Vehicle vehicle:vehicles){
				if(ride.getSource().equalsIgnoreCase(vehicle.getLocation())){
					 canBeScheduled =true;
					break;
				}
			}
			
			if(!canBeScheduled){
				ride.canBeScheduled = false;
				System.out.println("Ride wit ID:" + ride.getID() + " cannot be scheduled at this time. No vehicle to pickup at location: " + ride.getSource() );
			}
			
		}
		
		
		
		//Step.1 : Group Rides By Source Location
		Map<String, List<Ride>> requestedRideByLocation =
			    this.currentRides.stream().collect(Collectors.groupingBy(r -> r.getSource()));
		
		
		//Step.2 : Attaching 1 Vehicle to 4 Rides
		int totalRidesAttachedToVehicle = 0;
		
		for(Vehicle vehicle:vehicles){ //vehicle.location : SJC
			
			totalRidesAttachedToVehicle = 0; 
			
			String location = vehicle.getLocation(); //SJC
			
			for (Map.Entry<String, List<Ride>> entry : requestedRideByLocation.entrySet()) //SJC
			{
			    //System.out.println(entry.getKey() + "/" + entry.getValue());
				for(Ride ride:entry.getValue()){
					
					if(ride.vehicle==null && ride.canBeScheduled==true){
						if(location.equalsIgnoreCase(ride.getSource())){  //SJC
							
							System.out.println("ATTACHING VEHICLE TO RIDE....");
							totalRidesAttachedToVehicle++;
							
							//1st time
							if(!vehicle.isAttachedToRide){
								ride.setVehicle(vehicle);
								vehicle.isAttachedToRide = true;
							}
							
							if(totalRidesAttachedToVehicle<5){
								ride.setVehicle(vehicle);
							}else{
								break;
							}
							
							
						}else{
							break;
						}
					}
				}
				
			}
			
			
			
			
		}
		
		//Results of Step.2
		
//		System.out.println("Carpooling  ALGO RESULT");
//		for(Ride r:this.currentRides){
//			if(r.vehicle!=null){
//				System.out.println("Ride ID : " + r.getID() + " Vehicle ID : " + r.vehicle.getvId()) ;
//			}else{
//					ride.canBeScheduled = false;
//					System.out.println("Ride wit ID:" + r.getID() + " cannot be scheduled at this time. Vehicles not available at :" + r.getSource() );
//			}
//		}
			
		//Step.3 : Group Rides By Source Location
		Map<String, List<Ride>> vehicleGroupedByRides =
			    this.currentRides.stream().collect(Collectors.groupingBy(r -> r.vehicle.getvId()));
		
		//Step.4 : Delete rides with same vehicle and create new ride
		
	}
	
}
