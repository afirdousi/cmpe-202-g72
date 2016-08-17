/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.vehicle;

import com.project.lts.accounts.Member;
import com.project.lts.vehicle.VPending;
import com.project.lts.vehicle.VehicleState;

public abstract class Vehicle
{
	
	public String vId;
	public String vModel;
	public String vYear;
	public String vIn; 
	public int vehicleType;
	public VehicleState vehicleState;
	public int vHealth;
	public String vDriver;
	public String location;
	public String vehicleCost;
	public Member owner;
	public boolean isAttachedToRide;
	
	public Vehicle(){
		vehicleState = new VPending();
		isAttachedToRide = false;
	}
	
	public boolean getIsAttachedToRide() {
		return isAttachedToRide;
	}

	public void setIsAttachedToRide(boolean isAttached) {
		this.isAttachedToRide = isAttached;
	}
	
	
	public Member getMember(){
		return this.owner;
	}
	
	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getvDriver() {
		return vDriver;
	}



	public void setvDriver(String vDriver) {
		this.vDriver = vDriver;
	}



	public String getvId() {
		return vId;
	}


	public void setvId(String vId) {
		this.vId = vId;
	}


	public String getvModel() {
		return vModel;
	}


	public void setvModel(String vModel) {
		this.vModel = vModel;
	}


	public String getvYear() {
		return vYear;
	}


	public void setvYear(String vYear2) {
		this.vYear = vYear2;
	}


	public String getvIn() {
		return vIn;
	}


	public void setvIn(String vIn) {
		this.vIn = vIn;
	}



	public int getvHealth() {
		return vHealth;
	}


	public void setvHealth(int vHealth2) {
		this.vHealth = vHealth2;
	}
	
	public void setVehicleState(VehicleState vs) {
		vehicleState = vs;	
	}
	
	public VehicleState getVehicleState() {
		return vehicleState;	
	}
	
	public void setVehicleType(int vType) {
		// TODO implement me	
		vehicleType = vType;
	}
	
	public int getVehicleType() {
		return vehicleType;	
	}
	
	public void decorateVehicle() {
		// TODO implement me	
	}
	
	public abstract double cost();
	public abstract String getFeatureDescription();
	
}
