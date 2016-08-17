package com.project.lts.scheduler;
import java.util.*;

import com.project.lts.accounts.AccountClient;
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
		
		for (Member m : members) {
			if(m.getMemType()=="C" && m.getnMemberID()!="Cust001"){
//				customersOfCurrentRide = new ArrayList<Member>();
//				customersOfCurrentRide.add(m);
				ride  =  new Ride(Long.toString(this.rideCount),"SJC","SFO","8/20/2016",m,"","","","");
				this.currentRides.add(ride);
				this.rideCount++;
			}
		
		}
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
	
	public void displayRideInfo(Ride r){
		//TODO: Fix this
//		System.out.println("No of customer = " + r.customers.size());
//		System.out.println("Name of customer = " + r.customers.get(0).getMemFname());
		System.out.println("ID: " + r.ID + " | Source: " + r.source + " | Destination: " + r.destination + " | Date: " + r.rideDate );//+ " | Requester: " + r.customers.get(0).getMemFname());
		
	}
	
	public void scheduleAll(){
		
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
}
