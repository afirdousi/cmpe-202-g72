/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.vehicle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.project.lts.vehicle.InfantCarSeat;
import com.project.lts.vehicle.WheelChair;

public class VehicleManager
{
	Vehicle veh;
	ArrayList<Vehicle> vArr;
	public VehicleManager(){
		veh = new Car();
		this.vArr = new ArrayList<Vehicle>();
		//super();
		
		initVehicleData();
	}

	public ArrayList<Vehicle> getvArr() {
		return vArr;
	}



	public void setvArr(ArrayList<Vehicle> vArr) {
		this.vArr = vArr;
	}

	public void initVehicleData() {

		Vehicle v1 = new Car();
		v1.setvId("V0001");
		v1.setvModel("Toyota");
		v1.setvYear("2014");
		v1.setvIn("1234567890");
		v1.setVehicleType(1);
		v1.setvHealth(1);
		v1.setvDriver("D0001");
		v1.setLocation("94086");
		v1.setVehicleState(new VActive());
		
		this.vArr.add(v1);
		
		
		
		Vehicle v2 = new Car();
		v2.setvId("V0002");
		v2.setvModel("Lexus");
		v2.setvYear("2013");
		v2.setvIn("3245642176");
		v2.setVehicleType(1);
		v2.setvHealth(1);
		v2.setvDriver("D0003");
		v2.setLocation("95112");
		v2.setVehicleState(new VActive());
		
		this.vArr.add(v2);

		
		
		Vehicle v3 = new Car();
		v3.setvId("V0003");
		v3.setvModel("Honda");
		v3.setvYear("2013");
		v3.setvIn("7295642138");
		v3.setVehicleType(2);
		v3.setvHealth(2);
		v3.setvDriver(null);
		v3.setLocation("94087");
		v3.setVehicleState(new VActive());
		
		this.vArr.add(v3);
		
	

	}

	public Vehicle addVehicle(String vModel,String vYear,String vIn,int vType,int vHealth,String vDriver,String location,int voption) {
		
		
		Vehicle veh = new Car();
		int vIdSize = this.vArr.size();
		String vId = "V000" + (vIdSize + 1);
		veh.setvId(vId);
		veh.setvModel(vModel);
		veh.setvYear(vYear);
		veh.setvIn(vIn);
		veh.setVehicleType(vType);
		veh.setvHealth(vHealth);
		veh.setvDriver(vDriver);
		veh.setLocation(location);
		System.out.println("Vehicle added - Vehicle ID:" + veh.getvId()+" Vehicle Driver ID:" + veh.getvDriver());
		//add to array
		//this.vArr.add(veh);
		if (voption ==1) {
			WheelChair wc = new WheelChair(veh);
			this.vArr.add(wc);
			wc.setvId(vId);
			wc.setvModel(vModel);
			wc.setvYear(vYear);
			wc.setvIn(vIn);
			wc.setVehicleType(vType);
			wc.setvHealth(vHealth);
			wc.setvDriver(vDriver);
			wc.setLocation(location);
			System.out.println("------------------------------------------------------------");
			System.out.println("DECORATOR Pattern..adding WheelChair = "+wc.getFeatureDescription()); 
			   
		}
		else
		{
			if (voption ==2) {
				InfantCarSeat iseat = new InfantCarSeat(veh);
				iseat.setvId(vId);
				iseat.setvModel(vModel);
				iseat.setvYear(vYear);
				iseat.setvIn(vIn);
				iseat.setVehicleType(vType);
				iseat.setvHealth(vHealth);
				iseat.setvDriver(vDriver);
				iseat.setLocation(location);
				this.vArr.add(iseat);
				System.out.println("------------------------------------------------------------");
				System.out.println("DECORATOR Pattern..adding Infant car seat  = "+iseat.getFeatureDescription()); 
				   
			}
			else
				if (voption ==3) {
					
					System.out.println("------------------------------------------------------------");
					System.out.println("DECORATOR Pattern..adding No Special features"); 
					this.vArr.add(veh);   
				}	
			
			
		}
		System.out.println("Added the vehicle "+veh.vModel+veh.vId+veh.location+veh.getFeatureDescription());
		return veh;
		
	}
	
	public void retrieveVehicle() {
		// Retrieves all the vehicles added
		System.out.println("Retrieved Vehicles");
		System.out.println("Model      Vechile ID    Location     Feature    Driver");
		for (Vehicle v : this.vArr) {
			System.out.println(v.vModel+v.vId+v.location+v.getFeatureDescription()+v.getvDriver());
			
		}


		
	}
	
	public void deleteVehicle(String vId) {
		// TODO implement me	
	  /* 
		for (Vehicle v : this.vArr) {

			System.out.println("Vehicle " +v);
			if (v.getvId().equals(vId)){
				this.vArr.remove(v);
				System.out.println("Vehicle of ID "+vId+" has been removed");
			}
	*/
       for(Iterator<Vehicle> iter = vArr.iterator(); iter.hasNext(); ) {
            Vehicle v1 = iter.next();
            if(v1.getvId().equals(vId)) {
               iter.remove();
               System.out.println("Vehicle of ID "+vId+" has been removed");
             }
        }// for*/
		
        //Print the content after deletion
        System.out.println("List of available vehicles after deletion");
        for(Iterator<Vehicle> iter = vArr.iterator(); iter.hasNext(); ) {
            Vehicle v1 = iter.next();
            System.out.println(v1.vModel+v1.vId+v1.location+v1.getFeatureDescription()+v1.getvDriver());
        }
}
			
	
		
        

		
	public void updateVehicle(String vId, String vDriver) {
		
		for (Vehicle v : this.vArr) {

			if (v.getvId().equals(vId)){
				v.setvDriver(vDriver);
				System.out.println("Vehicle of ID "+vId+" has been updated");
			}
			
		}
		
	}
	
}