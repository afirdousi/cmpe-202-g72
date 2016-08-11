/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.vehicle;

import com.project.lts.vehicle.Vehicle;

public  interface VehicleState 
{
	/*public String receiveRequest();
	public String addVehicle();
	public String activeVehicle();*/
	//public void updateVehicleState() ;
	public void doAction(Vehicle vehicle);
	
	
}
