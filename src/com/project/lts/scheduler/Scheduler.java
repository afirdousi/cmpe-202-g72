package com.project.lts.scheduler;
import java.util.*;

import com.project.lts.accounts.AccountClient;
import com.project.lts.accounts.Member;
import com.project.lts.vehicle.Vehicle;

public class Scheduler {

	public List<Ride> currentRides;
	Ride ride;
	
	public Scheduler(){
		currentRides = new ArrayList<Ride>();
	}
	
	public void setupMockRide(List<Member> members){
		
		for (Member m : members) {
			if(m.getMemType()=="C"){
				ride  =  new Ride("R1","SJC","SFO",m,"","","","");
				currentRides.add(ride);
			}
		
		}
	}
	
	
	
}
