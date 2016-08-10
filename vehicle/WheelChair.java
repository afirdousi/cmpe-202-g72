/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.vehicle;

import com.project.lts.vehicle.Vehicle;
import com.project.lts.vehicle.VehicleDecorator;

public class WheelChair extends VehicleDecorator
{
	public WheelChair(Vehicle vDec){
		super(vDec);
	}
	
	public double cost() {
		// TODO implement me
		return vDec.cost()+ 5;
	}
	
	public String getFeatureDescription() {
		// TODO implement me
		
		return vDec.getFeatureDescription() + "+ Wheel Chair Feature --> " + "( $5 extra fee apply ) ";
	}
	
}
