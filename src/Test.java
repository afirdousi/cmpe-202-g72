import java.util.*;

import com.project.lts.accounts.*;
import com.project.lts.routing.Vertex;
import com.project.lts.scheduler.Ride;
import com.project.lts.scheduler.ScheduledRide;
import com.project.lts.scheduler.Scheduler;

import com.project.lts.vehicle.*;

public class Test {
	
	private enum STATE {
		MAIN_MENU,
		SIGN_UP,
		LOGIN,
		MEMBER_MENU,
		VEHICLE_MENU,
		SCHEDULE_MENU,
		GUEST,
		USER
	}
	
	public static void render(STATE state){
		
		switch(state){
			case MAIN_MENU:renderMainMenu(); break;
			case SIGN_UP:renderSignUpMenu();break;
			case LOGIN:renderLogin();break;
			case MEMBER_MENU:renderMemberMenu();break;
			case VEHICLE_MENU:renderVehicleMenu();break;
			case SCHEDULE_MENU:renderScheduleMenu();break;
			default: break;
		
		}
		
	}
	
	public static void renderHeader(){
		clearConsole();
		System.out.println("|--------------------------------------------------------------------------|");
		System.out.println("|-----------------Lyft Ride & Carpool Management System--------------------|");
		System.out.println("|--------------------------------------------------------------------------|");
	}

	public static void renderMainMenu(){
		renderHeader();
		System.out.println("\n");
		System.out.println("[1] Sign Up \n [2] Login \n [3] Exit \n");
		
		Scanner scan = new Scanner(System.in);
		int choice = Integer.parseInt(scan.nextLine());

		switch (choice) {
		case 1:
			render(STATE.SIGN_UP);
			break;
		case 2:
			render(STATE.LOGIN);
			break;
		case 3:
			System.out.println("Return to Main Menu");
			break;
		default:
			System.out.println("Invalid Option .... Please Try Again");
			render(STATE.MAIN_MENU);
			break;
		}
		
		
	}

	public static void renderSignUpMenu(){
		//renderHeader();
		System.out.println("Sign Up\n \n");
		System.out.println("\n[1] Home \n [2] Profile \n [3] Update Profile \n [4] Schedule Ride \n [5] My Rides \n [6]Reports");
		//System.out.println("\t[1] Home \t\t \n\n Enter Pickup Location: \n\n Enter Dropoff Location: \n\n Enter Type of Car: \n\n Enter No. of Seats: \n\n Do you need infant seat?[Y/N]: \n\n Enter \n\n Enter ");
		//System.out.println("\t[1] Home  \n\n \t 001 \t 8/10/2016\t SJC\t SFO\t $10.00 \n\t 002 \t 8/9/2016\t SJC\t RDC\t $27.00 \n\t 003 \t 8/9/2016\t SJC\t RCT\t $42.00 ");
	}
	
	public static int renderLogin(){
		//renderHeader();
		
		Scanner scan = new Scanner(System.in);
		String userName,password;// = Integer.parseInt(scan.nextLine());
		
		System.out.println("\n");
		System.out.println("\n[1] Enter Username:");
		userName = scan.nextLine();
		System.out.println("\n[1] Enter Password:");
		password = scan.nextLine();
		
		if(userName=="test" && password =="123"){
			return 1;
		}else{
			System.out.println("Wrong credentials");
			return -1;
		}
	}
	
	public static void renderMemberMenu(){

		//renderHeader();
		System.out.println("\n");
		System.out.println("\n[1] Home \n [2] Profile \n [3] Update Profile \n  [4] Schedule Ride \n [5] My Rides \n [6]Reports");
	}
	
	public static void renderVehicleMenu(){

		//renderHeader();
		System.out.println("\n");
		System.out.println("\n[1] Home \n [2] Profile \n [3] Update Profile \n  [4] Schedule Ride \n [5] My Rides \n [6]Reports");
	}
	
	public static void renderScheduleMenu(){

		//renderHeader();
		System.out.println("\n");
		System.out.println("\n[1] Home \n [2] Profile \n [3] Update Profile \n  [4] Schedule Ride \n [5] My Rides \n [6]Reports");
	}
		
	public final static void clearConsole()
	{
		//System.out.println("Clear console...");
	    try
	    {
	        final String os = System.getProperty("os.name");
	        //System.out.println(os);	
	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {	
	        	//System.out.println("Running : Runtime.getRuntime().exec('clear')");
	            Runtime.getRuntime().exec("clear");
	           // System.out.print("\f");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    	System.out.println("EXCEPTION : " + e.getMessage());
	    }
	}
	
	public static void main(String[] args){
		
		//////////////////////////////////////////////////////////////
		//Environment Setup
		//////////////////////////////////////////////////////////////
		
		
		System.out.println("Setting up environment...");
		
		System.out.println("*********************************");
		System.out.println("Mocking Up Members...");
		System.out.println("*********************************");
		
		AccountManager accManager = new AccountManager();
		accManager.setMockMembers();
		
		
		for (Member m : accManager.members) {
			//System.out.println("ID :" + m.getnMemberID() + " | First Name " + m.getMemFname() + "| Email "  + m.getMemEmail());
		}
		
		System.out.println("\nSTATUS: 10 Members created.\n");
		
		System.out.println("*********************************");
		System.out.println("Mocking Up Vehicle...");
		System.out.println("*********************************");
		
		VehicleManager vehManager = new VehicleManager();
		vehManager.setMockVehicles();
		
		for (Vehicle v : vehManager.vehicles) {
			//System.out.println("ID : " +v.vId + " | "  + v.getvDriver());
		}
		
		System.out.println("\nSTATUS: 10 Vehicles created.\n");

		System.out.println("*********************************");
		System.out.println("Mocking Up Ride Request...");
		System.out.println("*********************************");
		
		Scheduler schManager = new Scheduler(); 
		schManager.setupMockRide(accManager.members);
		
		System.out.println(schManager.currentRides);
		
		for (Ride v : schManager.currentRides) {
			System.out.println("ID : " + v.getID() + " | Customer : " + v.getMemberName() + " | From :" + v.getSource() + " | To :" + v.getDestination());
		}
		
		System.out.println("\nSTATUS: 10 Mock Rides ready to be scheduled.\n");
		
		System.out.println("*********************************");
		System.out.println("Scheduling Ride...");
		System.out.println("*********************************");
		
		List<List<Vertex>> suggestedRoutes;
		ScheduledRide scheduleRideManager;
		
		for (Ride v : schManager.currentRides) {
			scheduleRideManager = v.getRoute();
			String source = v.getSource();
			String destination = v.getDestination();
			
			scheduleRideManager.receiveRequest(source,destination);
			suggestedRoutes  = scheduleRideManager.calculateRide(source, destination);
			
			List<Vertex> selectedRoute = suggestedRoutes.get(0);
			System.out.println(selectedRoute);
			
			scheduleRideManager.dispatchRide(suggestedRoutes,0);
		}	
		
		
		//////////////////////////////////////////////////////////////
		//Menu Setup
		//////////////////////////////////////////////////////////////
		
		//render(STATE.MAIN_MENU);
		
		
		
		
		
		
	}

}
