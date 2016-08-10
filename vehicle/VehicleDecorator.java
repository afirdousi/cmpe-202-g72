/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.vehicle;

import com.project.lts.vehicle.Vehicle;

public abstract class VehicleDecorator extends Vehicle
{
	protected Vehicle vDec;
	
	public VehicleDecorator(Vehicle vDec){
		this.vDec = vDec;
	}
	
	public String getFeatureDescription() {
		return vDec.getFeatureDescription();
	}
	
}