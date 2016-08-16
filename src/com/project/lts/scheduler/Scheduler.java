package com.project.lts.scheduler;
import java.util.*;

import com.project.lts.accounts.AccountClient;
import com.project.lts.accounts.Member;
import com.project.lts.notification.Notification;
import com.project.lts.vehicle.Vehicle;

public class Scheduler {

	public List<Ride> currentRides;
	Ride ride;
	ArrayList<Member> customers;
	long rideCount=1;
	Notification notificationManager=new Notification();
	
	public Scheduler(){
		currentRides = new ArrayList<Ride>();
	}
	
	public void setupMockRide(List<Member> members){
		
		for (Member m : members) {
			if(m.getMemType()=="C" && m.getnMemberID()!="Cust001"){
				customers = new ArrayList<Member>();
				customers.add(m);
				ride  =  new Ride(Long.toString(this.rideCount),"SJC","SFO","24th August",customers,"","","","");
				currentRides.add(ride);
				this.rideCount++;
			}
		
		}
	}
	
	public long getTotalRideCount(){
		return this.rideCount;
	}
	
	public void addRide(Ride ride, Member currentUser){
		ride.ID=Long.toString(this.rideCount);
		this.currentRides.add(ride);
		this.rideCount++;
		notificationManager.reset();
		notificationManager.setListener(currentUser);
		notificationManager.setMessage("New Ride added to be schedueld!");
	    notificationManager.send();
				

	}
	
}
