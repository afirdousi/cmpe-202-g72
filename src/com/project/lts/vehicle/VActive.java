
/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/
package com.project.lts.vehicle;

import com.project.lts.vehicle.Vehicle;
import com.project.lts.vehicle.VehicleState;

public class VActive implements VehicleState
{
	
	public Vehicle vehicle;
	Vehicle veh;

	public VActive(){

		super();
	}
	
	public void doAction(Vehicle vehicle){
		System.out.println("------------------------------------------------------------");
		System.out.println("Current STATE : Vehicle moved to Active state");
		vehicle.setVehicleState(this);
		/*if (vehicle.getvDriver() != null){
			VAssigned va = new VAssigned();
        	vehicle.setVehicleState(new VAssigned());
			va.doAction(vehicle);
		}*/
		
      }
}
	
