/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleClient {
	public static Vehicle vehicle = new Car();
	public static String vId;
	public static  List<Vehicle> vehicles = new ArrayList<Vehicle>();
	static VehicleManager vm = new VehicleManager();
	
	//public static void main(String[] args){
	public void manageVehicle(){
		
		
			String vDriver;
			//Added Aug 7
			int s =0;
			do {
			   System.out.println("LTS Vehicle Management");
			   System.out.println("------------------------");
			   System.out.println("1. Add Vehicle");
			   System.out.println("2. Retrieve Vehicle");
			   System.out.println("3. Update Vehicle");
			   System.out.println("4. Remove Vehicle");
			   System.out.println("5. Return to Main Menu");
			   //System.out.println("6. Exit");
			   System.out.println("Enter your option");
			   Scanner scanner3 = new Scanner(System.in );
			   s = scanner3.nextInt ();
			   if (s == 1){
				
				Scanner sc = new Scanner(System.in);
				System.out.println("\nPlease enter Vehicle Model");
				String vModel = sc.nextLine();
				System.out.println("\nPlease enter Vehicle Year");
				String vYear = sc.nextLine();
				System.out.println("\nPlease enter Vehicle Identification Number(VIN)");
				String vIn = sc.nextLine();
				System.out.println("\nPlease choose a Vehicle Type");
				System.out.println("1. Contractor Owned");
				System.out.println("2. Company Owned");
				int vType = sc.nextInt();
				if (vType == 1){
					System.out.println("\nPlease enter Driver ID");
					//vDriver = sc.nextLine();
					Scanner sc1 = new Scanner(System.in);
					vDriver = (sc1.nextLine());
				}else {vDriver = null;}				
				System.out.println("\nIs Vehicle Health good or bad");
				System.out.println("1. Good");
				System.out.println("2. Bad");
				int vHealth = sc.nextInt();
				System.out.println("\nPlease enter Vehicle Location");
				Scanner sc2 = new Scanner(System.in);
				String location = (sc2.nextLine());
				
				System.out.println("Please enter DECORATOR Options : \n");
				System.out.println("1. WheelChair");
				System.out.println("2. Infant Car Seat");
				System.out.println("3. No special option");
			
				Scanner sc9 = new Scanner(System.in);
				int voption = sc9.nextInt();
				if (voption == 1)
					vehicle = vm.addVehicle(vModel,vYear,vIn,vType,vHealth,vDriver,location,voption);
				else
				   vehicle = vm.addVehicle(vModel,vYear,vIn,vType,vHealth,vDriver,location,voption);

				vehicle.setVehicleState(new VPending());
				VPending vp = new VPending();
				vp.doAction(vehicle);
				//vp.doAction(v);

			}
			else if (s == 2){
				
				vm.retrieveVehicle();
				System.out.println("------------------------------------");
				System.out.println("Vehicle has been retrieved");
				
			}
			
			else if (s == 3){
				System.out.println("Enter ID of vehicle to be updated");
				Scanner scanner4 = new Scanner(System.in);
				vId = (scanner4.nextLine());
				System.out.println("Enter Driver ID");
				Scanner scanner5 = new Scanner(System.in);
				String vDri = (scanner5.nextLine());
				vm.updateVehicle(vId,vDri);
				System.out.println("Vehicle of ID "+vId+" has been updated");
				
			}
			
			else if (s == 4){
				System.out.println("Enter Vehicle ID");
				Scanner scanner4 = new Scanner(System.in);
				vId = (scanner4.nextLine());
				vm.deleteVehicle(vId);
				System.out.println("Vehicle of ID "+vId+" has been removed");
				
			} //else
	        if (s==5)
	        	break;
		
	}	 while (s!=5);	

	}
		
}
