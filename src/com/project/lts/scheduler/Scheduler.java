package com.project.lts.scheduler;
import java.util.*;

import com.project.lts.accounts.AccountClient;
import com.project.lts.accounts.Member;
import com.project.lts.vehicle.Vehicle;

public class Scheduler {

	public List<Ride> currentRides;
	Ride ride;
	ArrayList<Member> customers;
	
	public Scheduler(){
		currentRides = new ArrayList<Ride>();
	}
	
	public void setupMockRide(List<Member> members){
		
		for (Member m : members) {
			if(m.getMemType()=="C" && m.getnMemberID()!="Cust001"){
				customers = new ArrayList<Member>();
				customers.add(m);
				ride  =  new Ride("R1","SJC","SFO",customers,"","","","");
				currentRides.add(ride);
			}
		
		}
	}
	
	
	
}
