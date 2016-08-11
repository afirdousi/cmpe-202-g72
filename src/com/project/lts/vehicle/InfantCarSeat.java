/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/
package com.project.lts.vehicle;

import com.project.lts.vehicle.Vehicle;
import com.project.lts.vehicle.VehicleDecorator;

public class InfantCarSeat extends VehicleDecorator
{
	public InfantCarSeat(Vehicle vDec){
		super(vDec);
	}
	
	public double cost() {
		// TODO implement me
		// 
		return vDec.cost()+2;
	}
	
	public String getFeatureDescription() {
		// TODO implement me
		System.out.println("Infant Car Seat");
		return vDec.getFeatureDescription() + "+ Infant Car Seat --> " + "( $2 extra fee apply ) ";
	}
	
}