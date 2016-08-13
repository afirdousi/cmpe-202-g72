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
	public Vehicle veh;
	public ArrayList<Vehicle> vehicles;
	
	public VehicleManager(){
		veh = new Car();
		this.vehicles = new ArrayList<Vehicle>();
		//super();
	}

	public ArrayList<Vehicle> setMockVehicles() {
		initVehicleData();
		return vehicles;
	}

	public void setvehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public void initVehicleData() {

		Vehicle v1 = new Car();
		v1.setvId("V0001");
		v1.setvModel("Toyota");
		v1.setvYear("2011");
		v1.setvIn("1234567890");
		v1.setVehicleType(1);
		v1.setvHealth(1);
		v1.setvDriver("D0001");
		v1.setLocation("SJC");
		v1.setVehicleState(new VActive());
        this.vehicles.add(v1);

		Vehicle v2 = new Car();
		v2.setvId("V0002");
		v2.setvModel("HONDA");
		v2.setvYear("2012");
		v2.setvIn("2234567890");
		v2.setVehicleType(1);
		v1.setvHealth(1);
		v2.setvDriver("D0002");
		v2.setLocation("SJC");
		v2.setVehicleState(new VActive());
         this.vehicles.add(v2);
                
		Vehicle v3 = new Car();
		v3.setvId("V0003");
		v3.setvModel("BMW");
		v3.setvYear("2013");
		v3.setvIn("3234567890");
		v3.setVehicleType(1);
		v3.setvHealth(1);
		v3.setvDriver("D0003");
		v3.setLocation("SJC");
		v3.setVehicleState(new VActive());
                this.vehicles.add(v3);

		Vehicle v4 = new Car();
		v4.setvId("V0004");
		v4.setvModel("Volkswagen");
		v4.setvYear("2014");
		v4.setvIn("4234567890");
		v4.setVehicleType(1);
		v4.setvHealth(1);
		v4.setvDriver("D0004");
		v4.setLocation("SJC");
		v4.setVehicleState(new VActive());
        this.vehicles.add(v4);

		Vehicle v5 = new Car();
		v5.setvId("V0005");
		v5.setvModel("ACURA");
		v5.setvYear("2014");
		v5.setvIn("5234567890");
		v5.setVehicleType(1);
		v5.setvHealth(1);
		v5.setvDriver("D0005");
		v5.setLocation("SFO");
		v5.setVehicleState(new VActive());
        this.vehicles.add(v5);

		Vehicle v6 = new Car();
		v6.setvId("V0006");
		v6.setvModel("LEXUS");
		v6.setvYear("2014");
		v6.setvIn("6234567890");
		v6.setVehicleType(1);
		v6.setvHealth(1);
		v6.setvDriver("D0006");
		v6.setLocation("SFO");
		v6.setVehicleState(new VActive());
                this.vehicles.add(v6);

		Vehicle v7 = new Car();
		v7.setvId("V0007");
		v7.setvModel("Mercedes Benz");
		v7.setvYear("2014");
		v7.setvIn("7234567890");
		v7.setVehicleType(1);
		v7.setvHealth(1);
		v7.setvDriver("D0007");
		v7.setLocation("SFO");
		v7.setVehicleState(new VActive());
                this.vehicles.add(v7);

		Vehicle v8 = new Car();
		v8.setvId("V0008");
		v8.setvModel("Porsche");
		v8.setvYear("2014");
		v8.setvIn("8234567890");
		v8.setVehicleType(1);
		v8.setvHealth(1);
		v8.setvDriver("D0008");
		v8.setLocation("SFO");
		v8.setVehicleState(new VActive());
                this.vehicles.add(v8);

		Vehicle v9 = new Car();
		v9.setvId("V0009");
		v9.setvModel("FORD");
		v9.setvYear("2014");
		v9.setvIn("9234567890");
		v9.setVehicleType(1);
		v9.setvHealth(1);
		v9.setvDriver("D0009");
		v9.setLocation("MTV");
		v9.setVehicleState(new VActive());
                this.vehicles.add(v9);

		Vehicle v10 = new Car();
		v10.setvId("V0010");
		v10.setvModel("Chevrolet");
		v10.setvYear("2014");
		v10.setvIn("A234567890");
		v10.setVehicleType(1);
		v10.setvHealth(1);
		v10.setvDriver("D0010");
		v10.setLocation("MTV");
		v10.setVehicleState(new VActive());
                this.vehicles.add(v10);
 
		Vehicle v11 = new Car();
		v11.setvId("V0011");
		v11.setvModel("Buick");
		v11.setvYear("2014");
		v11.setvIn("B234567890");
		v11.setVehicleType(1);
		v11.setvHealth(1);
		v11.setvDriver("D0011");
		v11.setLocation("RWC");
		v11.setVehicleState(new VActive());
                this.vehicles.add(v11);

		Vehicle v12 = new Car();
		v12.setvId("V0012");
		v12.setvModel("GMC");
		v12.setvYear("2014");
		v12.setvIn("C234567890");
		v12.setVehicleType(1);
		v12.setvHealth(1);
		v12.setvDriver("D0012");
		v12.setLocation("RWC");
		v12.setVehicleState(new VActive());
                this.vehicles.add(v12);

		Vehicle v13 = new Car();
		v13.setvId("V0013");
		v13.setvModel("Cadillac");
		v13.setvYear("2014");
		v13.setvIn("D234567890");
		v13.setVehicleType(1);
		v13.setvHealth(1);
		v13.setvDriver("D0012");
		v13.setLocation("RWC");
		v13.setVehicleState(new VActive());
                this.vehicles.add(v13);

		Vehicle v14 = new Car();
		v14.setvId("V0014");
		v14.setvModel("DODGE");
		v14.setvYear("2014");
		v14.setvIn("E234567890");
		v14.setVehicleType(1);
		v14.setvHealth(1);
		v14.setvDriver("D0012");
		v14.setLocation("RWC");
		v14.setVehicleState(new VActive());
                this.vehicles.add(v14);

		Vehicle v15 = new Car();
		v15.setvId("V0015");
		v15.setvModel("Chrysler");
		v15.setvYear("2014");
		v15.setvIn("F234567890");
		v15.setVehicleType(1);
		v15.setvHealth(1);
		v15.setvDriver("D0012");
		v15.setLocation("RWC");
		v15.setVehicleState(new VActive());
                this.vehicles.add(v15);
		
	

	}

	public Vehicle addVehicle(String vModel,String vYear,String vIn,int vType,int vHealth,String vDriver,String location,int voption) {
		
		
		Vehicle veh = new Car();
		int vIdSize = this.vehicles.size();
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
		//this.vehicles.add(veh);
		if (voption ==1) {
			WheelChair wc = new WheelChair(veh);
			this.vehicles.add(wc);
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
				this.vehicles.add(iseat);
				System.out.println("------------------------------------------------------------");
				System.out.println("DECORATOR Pattern..adding Infant car seat  = "+iseat.getFeatureDescription()); 
				   
			}
			else
				if (voption ==3) {
					
					System.out.println("------------------------------------------------------------");
					System.out.println("DECORATOR Pattern..adding No Special features"); 
					this.vehicles.add(veh);   
				}	
			
			
		}
		System.out.println("Added the vehicle "+veh.vModel+veh.vId+veh.location+veh.getFeatureDescription());
		return veh;
		
	}
	
	public void retrieveVehicle() {
		// Retrieves all the vehicles added
		System.out.println("Retrieved Vehicles");
		System.out.println("Model      Vechile ID    Location     Feature    Driver");
		for (Vehicle v : this.vehicles) {
			System.out.println(v.vModel+" * "+v.vId+" * "+v.location+" * "+v.getFeatureDescription()+" * "+v.getvDriver());
			
		}
	}
	
	public void deleteVehicle(String vId) {
		// TODO implement me	
	  /* 
		for (Vehicle v : this.vehicles) {

			System.out.println("Vehicle " +v);
			if (v.getvId().equals(vId)){
				this.vehicles.remove(v);
				System.out.println("Vehicle of ID "+vId+" has been removed");
			}
	*/
       for(Iterator<Vehicle> iter = vehicles.iterator(); iter.hasNext(); ) {
            Vehicle v1 = iter.next();
            if(v1.getvId().equals(vId)) {
               iter.remove();
               System.out.println("Vehicle of ID "+vId+" has been removed");
             }
        }// for*/
		
        //Print the content after deletion
        System.out.println("List of available vehicles after deletion");
        for(Iterator<Vehicle> iter = vehicles.iterator(); iter.hasNext(); ) {
            Vehicle v1 = iter.next();
            System.out.println(v1.vModel+v1.vId+v1.location+v1.getFeatureDescription()+v1.getvDriver());
        }
}
		
	public void updateVehicle(String vId, String vDriver) {
		
		for (Vehicle v : this.vehicles) {

			if (v.getvId().equals(vId)){
				v.setvDriver(vDriver);
				System.out.println("Vehicle of ID "+vId+" has been updated");
			}
			
		}
		
	}
	
}