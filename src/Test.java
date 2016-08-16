import java.util.*;

import com.project.lts.accounts.*;
import com.project.lts.payment.Payment;
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
	
	static boolean loggedIn=false; 
	static AccountManager accManager;
	static VehicleManager vehManager;
	//static PaymentManager paymentManager;
	static Scanner inputManager;
	static int choice; 
	static Member currentUser;
	
	public static void render(STATE state){
		
		switch(state){
			case MAIN_MENU:renderMainMenu(); break;
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
		//renderHeader();
		System.out.println("\n");
		System.out.println("\n[1] Login \n[2] Exit \n");
		
		Scanner scan = new Scanner(System.in);
		int choice = Integer.parseInt(scan.nextLine());

		switch (choice) {
		case 1:
			int result = renderLogin();
			if(result==1){
				loggedIn=true;
			}
			
			while(loggedIn){
				
				renderMemberMenu();
				
				
				
				
			}
			
		case 2:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Option .... Please enter [1] or [2]");
			render(STATE.MAIN_MENU);
			break;
		}
		
		
	}
	
	public static int renderLogin(){
		//renderHeader();
		
		Scanner scan = new Scanner(System.in);
		String userName;
		int password;// = Integer.parseInt(scan.nextLine());
		
		while(true){
			System.out.println("\n");
			System.out.println("\n[1] Enter Username:");
			userName =  scan.nextLine();
			System.out.println("\n[1] Enter Password:");
			password = Integer.parseInt(scan.nextLine());
			
			if(password!=123){
				System.out.println("Wrong credentials");
			}else{
				break;
			}
			
		}
		//TODO:Fix this
//		if(userName.toString().trim()=="test" && password.toString().trim() =="123"){
//			return 1;
//		}else{
//			System.out.println("Wrong credentials");
//			return -1;
//		}
		
		return 1;
	}
	
	public static void renderMemberMenu(){

		//renderHeader();
		System.out.println("\n");
		System.out.println("\nWelcome to Lyft! \n***********************\n[1] CRUD Account \n[2] Request a Ride \n[3] My Rides  \n[4] Return to Main Menu \n ");
		
		Scanner scan = new Scanner(System.in);
		int choice = Integer.parseInt(scan.nextLine());

		switch (choice) {
		case 1:
			System.out.println("Create an Account");
			processRequest();

		case 2:
			System.out.println("Request Ride");
			
			//TODO: Pull in Ride Request here
			// this.reqClient.createRequest();

			break;

		case 3:
			System.out.println("Return to Main Menu");
			break;

		case 4:
			System.out.println("Exit");
			break;

		default:
			System.out.println("Invalid Option .... Please Try Again");
			renderMemberMenu();
			break;
		}
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
	
	public static void processRequest() {
	
		
		do {

			System.out.println("=============================================================");
			System.out.println("1. Add Member");
			System.out.println("2. Retrieve Member");
			System.out.println("3. Update Member");
			System.out.println("4. Delete Members");
			System.out.println("5. Select Members");
			System.out.println("6. Search Members");
			System.out.println("7. Sort Members");
			System.out.println("8. Back");
			System.out.println("9. Exit");
			System.out.println("Enter your option(1,2,3,4,5,6,7,8,9)");

			inputManager = new Scanner(System.in);
			choice = inputManager.nextInt();
			inputManager.nextLine();

			if (choice == 1)

			{
//				collectInput();
//				addanyMember();
			}



			if (choice == 2) {
				System.out.println("Retrieving Member ");
				System.out.println("Enter Member Id to be retrieved");
				inputManager = new Scanner(System.in);
//				strmFName = (inputManager.nextLine());
//				mops.retrieveCustomer(strmFName);
			

			}

			if (choice == 3) {
				System.out.println("Updating Member ");
				System.out.println("Enter Member First Name");
				inputManager = new Scanner(System.in);
				//strmFName = (inputManager.nextLine());
				System.out.println("Enter new email address");
				inputManager = new Scanner(System.in);
//				strmEmail = (inputManager.nextLine());
//				mops.updateCustomer(strmFName, strmEmail);

			}

			if (choice == 4) {
				System.out.println("Removing Member ");
				System.out.println("Enter Member First Name");
				inputManager = new Scanner(System.in);
//				strmFName = (inputManager.nextLine());
//				mops.removeCustomer(strmFName);
				// print after deletion
				System.out.println("Members list after removing a member ");
//				for (int j = 0; j < members1.size(); j++) {
//					System.out.println("First Name = " + members1.get(j).memFname + " Member Id = "
//							+ members1.get(j).nMemberID + " Member role= " + members1.get(j).memRole);
//				}
			}

			if (choice == 5) {
				System.out.println("Select Member - Enter Member First Name ");
				inputManager = new Scanner(System.in);
//				strmFName = (inputManager.nextLine());
				System.out.println("Displaying Selected Member email information ");
//				mops.selectCustomer(strmFName);

			}

			if (choice == 6) {
				System.out.println("Search Member based on MemberId ");
				inputManager = new Scanner(System.in);
//				custID = (inputManager.nextLine());
//				mops.SearchCustomer(custID);

			}

			if (choice == 7) {
				System.out.println("Sorting Members ");

				// Sort members based on their name

				// Collections.sort(members1, new SortComparator());
				//mops.sortCustomers();

			}
			if (choice == 8)
				break;

		} while (choice != 9 && choice !=8);


	}
	
	public static void main(String[] args){
		renderHeader();
		//////////////////////////////////////////////////////////////
		//Environment Setup
		//////////////////////////////////////////////////////////////
		Payment payment = new Payment();
		
		System.out.println("\n\n////////////////////////////////////////////////////////////// \nSetting up environment...\n////////////////////////////////////////////////////////////// \n");
		
		System.out.println("*********************************");
		System.out.println("Mocking Up Members...");
		System.out.println("*********************************");
		
		accManager = new AccountManager();
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
		
		//System.out.println(schManager.currentRides);
		
		for (Ride v : schManager.currentRides) {
			//System.out.println("ID : " + v.getID() + " | Customer : " + v.getMemberName() + " | From :" + v.getSource() + " | To :" + v.getDestination());
		}
		
//		System.out.println("\nSTATUS: 10 Mock Rides ready to be scheduled.\n");
//		
		
		//////////////////////////////////////////////////////////////
		//Scheduling all mocked ride requests
		//////////////////////////////////////////////////////////////
			
		
//		System.out.println("*********************************");
//		System.out.println("Scheduling Ride...");
//		System.out.println("*********************************");
//		
//		List<List<Vertex>> suggestedRoutes;
//		
//		ScheduledRide scheduleRideManager;
//		
//		for (Ride ride : schManager.currentRides) {
//			
//			scheduleRideManager = ride.getScheduledRide();
//			String source = ride.getSource();
//			String destination = ride.getDestination();
//			
//			//Step:1
//			scheduleRideManager.receiveRequest(source,destination);
//			
//			//Step:2
//			suggestedRoutes  = scheduleRideManager.calculateRide(source, destination);
//			
//			//Step:3
//			payment.holdPayment(10, accManager.members);
//			
//			//Step:4
//			scheduleRideManager.dispatchRide(suggestedRoutes,0);
//			
//			//Step:5
//			scheduleRideManager.completeRide(10, ride.getMembers());
//		}	
		
		//////////////////////////////////////////////////////////////
		//Current User of System 
		//////////////////////////////////////////////////////////////
		
		currentUser = accManager.members.get(0);
		
		
		//////////////////////////////////////////////////////////////
		//Menu Setup
		//////////////////////////////////////////////////////////////
		
		
		render(STATE.MAIN_MENU);
		
		
		
		
		
		
	}

}
