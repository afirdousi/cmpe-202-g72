/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.vehicle;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;


public class VPending implements VehicleState
{
	
	public Vehicle vehicle;
	
	public VPending(){
		super();
	}

	public void doAction(Vehicle vehicle){
			System.out.println("------------------------------------------------------------");
			System.out.println("Entering Vehicle --> STATE Pattern .....");
			System.out.println("Current STATE : Vehicle is in pending state - Requesting background check");
			vehicle.setVehicleState(this);
	        if (vehicle.vHealth == 1){
	        	VVerified vf = new VVerified();
	        	vehicle.setVehicleState(new VVerified());
				vf.doAction(vehicle);
	      }
	        else if(vehicle.vHealth == 2){
				System.out.println("Vehicle is rejected due to poor health. Try some other vehicle");

	      }
	}
}


