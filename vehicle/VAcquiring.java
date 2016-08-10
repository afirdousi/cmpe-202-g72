/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/
package com.project.lts.vehicle;

import com.project.lts.vehicle.VActive;
import com.project.lts.vehicle.Vehicle;
import com.project.lts.vehicle.VehicleState;

public class VAcquiring implements VehicleState{
	
public Vehicle vehicle;
	
	public VAcquiring(){
		super();
	}
	
	public void doAction(Vehicle vehicle){
		System.out.println("Vehicle is in acquiring state");
		vehicle.setVehicleState(this);
		
    
        	VActive va = new VActive();
        	vehicle.setVehicleState(new VActive());
			va.doAction(vehicle);
      
        
	}

}
