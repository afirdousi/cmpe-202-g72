/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.vehicle;

import com.project.lts.vehicle.Vehicle;

public class Car extends Vehicle
{

	public Car(){
		super();
	}
	
	public Car(String vId, String vModel, String vYear, String vIn, int vehicleType, int vHealth, String vDriver,String location) {
		// TODO Auto-generated constructor stub
		
		this.vId = vId;
		this.vModel = vModel;
		this.vYear = vYear;
		this.vIn = vIn;
		this.vehicleType = vehicleType;
		this.vHealth = vHealth;
		this.vDriver = vDriver;
		this.location = location;
	}

	public double cost() {
		// TODO implement me
		return 0.2;
	}
	
	public String getFeatureDescription() {
		return "Car";
	}
	
}
