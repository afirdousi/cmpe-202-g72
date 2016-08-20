import java.util.*;
import java.util.stream.Collectors;

import com.project.lts.accounts.*;
import com.project.lts.payment.Payment;
import com.project.lts.payment.PaymentManager;
import com.project.lts.report.Report;
import com.project.lts.report.Report.REPORTTYPE;
import com.project.lts.routing.Vertex;
import com.project.lts.scheduler.Ride;
import com.project.lts.scheduler.ScheduledRide;
import com.project.lts.scheduler.Scheduler;
import com.project.lts.notification.*;
//Aug 17 Thiagarajan Natarajan
import com.project.lts.rules.RuleManager;

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
	//Aug 17 Thiagarajan Natarajan rule manager related chnges
	static RuleManager ruleManager;
	static VehicleManager vehManager;
	static Scheduler schManager;
	static PaymentManager paymentManager;
	static Notification notificationManager;
	static Report reportManager;
	static Scanner inputManager;
	static Scanner inputVehicle;
	static int choice; 
	static Member currentUser;
	
	public static void render(STATE state){
		
		switch(state){
			case MAIN_MENU:renderMainMenu(); break;
			case LOGIN:renderLogin();break;
			case MEMBER_MENU:renderMemberMenu();break;
//			case VEHICLE_MENU:renderVehicleMenu();break;
//			case SCHEDULE_MENU:renderScheduleMenu();break;
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
			
			while(loggedIn){ // RUN UNTILL THE USER LOGS OUT
				
				
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
		
		return 1;
	}
	
	public static void renderMemberMenu(){

		//renderHeader();
		System.out.println("\n");
		System.out.println("\nWelcome to Lyft! \n***********************\n[1] CRUD Account \n[2] CRUD Vehicle  \n[3] Ride Options \n[4] Reports \n[5] CRUD Rule \n[6] Return to Main Menu \n ");
		
		Scanner scan = new Scanner(System.in);
		int choice = Integer.parseInt(scan.nextLine());

		switch (choice) {
		case 1:
			System.out.println("CRUD Account");
			//Aug 17 Thiagarajan N
			ruleManager.retrieveRule("All");
			renderMemberOptions();
			//Aug 17 Thiagarajan N added missing break
			break;

		case 2:
			System.out.println("CRUD Vehicle");
			
			//TODO: Pull in Ride Request here
			// this.reqClient.createRequest();
			//Aug 17 Thiagarajan N
			ruleManager.retrieveRule("All");
			renderVehicleOptions();

			break;

		case 3:
			renderRideOptions();
			break;

		case 4:
			System.out.println("Reports");
			renderReportOptions();
			break;
			
		//Aug 17 Thiagarajan Natarajan
		case 5:
			System.out.println("CRUD Rule");
			//ruleManager.setMockRules();
			ruleManager.showRulesmenu();
			break;
			
		case 6:
			System.out.println("Exit");
			break;

		default:
			System.out.println("Invalid Option .... Please Try Again");
			renderMemberMenu();
			break;
		}
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
	
	public static void renderMemberOptions() {
	
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
				addMember();
			}
			else if (choice == 2) {
				System.out.println("Retrieving Member ");
				System.out.println("Enter Member ID to be retrieved");
				inputManager = new Scanner(System.in);
				String ID = inputManager.nextLine();
				
				accManager.retrieveMember(ID);

			}

			else if (choice == 3) {
				System.out.println("Updating Member ");
				
				System.out.println("Enter Member ID to update");
				inputManager = new Scanner(System.in);
				String ID = (inputManager.nextLine());
				System.out.println("Enter Member First Name");
				inputManager = new Scanner(System.in);
				String firstName = (inputManager.nextLine());
				System.out.println("Enter new email address");
				inputManager = new Scanner(System.in);
				String email = (inputManager.nextLine());
				
				accManager.updateCustomer(ID, firstName, email);

			}

			else if (choice == 4) {
				System.out.println("Removing Member ");
				System.out.println("Enter Member ID to remove :");
				inputManager = new Scanner(System.in);
				String ID  = (inputManager.nextLine());
				accManager.removeCustomer(ID);

			}

			else if (choice == 5) {
				System.out.println("Select Member - Enter Member ID");
				inputManager = new Scanner(System.in);
				accManager.selectCustomer(inputManager.nextLine());

			}

			else if (choice == 6) {
				System.out.println("Search Member based on MemberId ");
				inputManager = new Scanner(System.in);
				accManager.searchCustomer(inputManager.nextLine());
			}

			else if (choice == 7) {
				System.out.println("Sorting Members ");
				accManager.sortCustomers();
			}
			else if (choice == 8)
				break;

		} while (choice != 9 && choice !=8);


	}

	public static void renderReportOptions() {

		do {

			System.out.println("=============================================================");
			System.out.println("1. All Member Report");
			System.out.println("2. All Rides Report");
			System.out.println("3. My Rides Report");
			System.out.println("4. Payment Report"); 
			System.out.println("5. Location Report");  
			System.out.println("6. Back");
			System.out.println("7. Exit");
			System.out.println("Enter your option(1,2,3,4,5,6,7)");

			inputManager = new Scanner(System.in);
			choice = inputManager.nextInt();
			inputManager.nextLine();

			if (choice == 1)
			{
				System.out.println("Choose Report Format [1] Excel [2]PDF");
				inputManager = new Scanner(System.in);
				choice = inputManager.nextInt();
				inputManager.nextLine();
				
				for(Member member:accManager.members){
					accManager.displayMember(member);
				}
		
				reportManager.generateReport(REPORTTYPE.MEMBER,choice , accManager.members.toArray(new Object[accManager.members.size()]));
			}
			else if (choice == 2) {
		
				System.out.println("Choose Report Format [1] Excel [2]PDF");
				inputManager = new Scanner(System.in);
				choice = inputManager.nextInt();
				inputManager.nextLine();
				
				for(Ride ride:schManager.currentRides){
					schManager.displayRideInfo(ride);
				}
				
				reportManager.generateReport(REPORTTYPE.RIDE,choice , schManager.currentRides.toArray(new Object[schManager.currentRides.size()]));
	
			}

			else if (choice == 3) {

				System.out.println("Choose Report Format [1] Excel [2]PDF");
				inputManager = new Scanner(System.in);
				choice = inputManager.nextInt();
				inputManager.nextLine();
				
				ArrayList<Ride> myRides = new ArrayList<Ride>();
	
				for (Ride ride : schManager.currentRides) {
						//members = ride.getMembers();
						for (Member member : ride.getMembers()) {
							if(member!=null){
								if(member.getnMemberID()==currentUser.getnMemberID()){
									myRides.add(ride);
								}
							}
						}
				}
				if(myRides.size()==0){
					System.out.println("No rides found.");
				}
				for(Ride ride:myRides){
					schManager.displayRideInfo(ride);
				}
				
				reportManager.generateReport(REPORTTYPE.MY_RIDE,choice , myRides.toArray(new Object[myRides.size()]));
			}

			else if (choice == 4) {
				paymentManager.showAllPaymentHistory();
			}

			else if (choice == 5) {
	
				//LOCATION REPORT
				Map<String, List<Ride>> ridesByLocation =
						schManager.currentRides.stream()
					    				 .collect(Collectors.groupingBy(r -> r.getSource()));
				
				for (Map.Entry<String, List<Ride>> entry : ridesByLocation.entrySet()) 
				{
					System.out.println(entry.getValue().get(0).getSource());
					for(Ride ride:entry.getValue()){
						System.out.println("Ride ID : " + ride.getID());
					}
				
				}
				
				
			}
	
			else if (choice == 6) {
				break;
			}

	} while (choice != 6 && choice !=7);


}
	public static void renderVehicleOptions() {
	    
	    do {

	      System.out.println("=============================================================");
	          
	      System.out.println("1. Add Vehicle");
	      System.out.println("2. Retrieve Vehicle");
	      System.out.println("3. Update Vehicle");
	      System.out.println("4. Remove Vehicle");
//	      System.out.println("5. Select Members");
//	      System.out.println("6. Search Members");
//	      System.out.println("7. Sort Members");
	      System.out.println("8. Back");
	      System.out.println("9. Exit");
	      System.out.println("Enter your option(1,2,3,4,5,6,7,8,9)");

	      inputManager = new Scanner(System.in);
	      choice = inputManager.nextInt();
	      inputManager.nextLine();

	      if (choice == 1)
	      {
	        addVehicle();
	      }
	      else if (choice == 2) {
	        System.out.println("Retrieving Vehicle ");
	        System.out.println("Enter Vehicle ID to be retrieved");
	        inputManager = new Scanner(System.in);
	        String ID = inputManager.nextLine();
	        vehManager.retrieveVehicle(ID);
	      }
	      else if (choice == 3) {
	        System.out.println("Updating Vehicle ");
	        
	        System.out.println("Enter Vehicle ID to update");
	        inputManager = new Scanner(System.in);
	        String ID = (inputManager.nextLine());
	        System.out.println("Enter New Driver Name");
	        inputManager = new Scanner(System.in);
	        String driverName = inputManager.nextLine();
	        
	        vehManager.updateVehicle(ID, driverName);

	      }

	      else if (choice == 4) {
	        System.out.println("Removing Vehicle ");
	        System.out.println("Enter Vehicle ID to remove :");
	        inputManager = new Scanner(System.in);
	        String ID  = (inputManager.nextLine());
	        vehManager.deleteVehicle(ID);

	      }

	      else if (choice == 5) {
	        System.out.println("Select Vehicle - Enter Vehicle First Name ");
	        inputManager = new Scanner(System.in);

	        System.out.println("Displaying Selected Vehicle email information ");


	      }

	      else if (choice == 6) {
	        System.out.println("Search Vehicle based on VehicleId ");
	        inputManager = new Scanner(System.in);

	      }

	      else if (choice == 7) {
	        System.out.println("Sorting Vehicles ");

	      }
	      else if (choice == 8)
	        break;

	    } while (choice != 9 && choice !=8);


	  }
	
	public static void renderRideOptions() {

		do {

			System.out.println("=============================================================");
			System.out.println("1. Request Ride(s)");
			System.out.println("2. Cancel a Ride");  
			System.out.println("3. Schedule All Rides");  
			System.out.println("4. Back");
			System.out.println("Enter your option(1,2,3,4,5)");

			inputManager = new Scanner(System.in);
			choice = inputManager.nextInt();
			inputManager.nextLine();

			if (choice == 1)
			{
				System.out.println("Request a Ride");
				addRideRequest();
			}
			else if (choice == 2) {
				System.out.println("Canceling Ride ");
				System.out.println("Enter Ride ID to remove :");
				inputManager = new Scanner(System.in);
				String rideID  = (inputManager.nextLine());
				schManager.removeRide(rideID,currentUser);

			}

			else if (choice == 3) {
				scheduleAllRides();
			}

			else if (choice == 4) {
				break;
			}

		} while (choice != 4);


	}
	
	
	public static void main(String[] args){
		renderHeader();
		//////////////////////////////////////////////////////////////
		//Environment Setup
		//////////////////////////////////////////////////////////////
		paymentManager = new PaymentManager();
		reportManager = new Report();
		notificationManager = new Notification();
		
		System.out.println("\n\n////////////////////////////////////////////////////////////// \nSetting up environment...\n////////////////////////////////////////////////////////////// \n");
		
		System.out.println("*********************************");
		System.out.println("Mocking Up Members...");
		System.out.println("*********************************");
		
		accManager = new AccountManager();
		//Aug 17 Thiagarajan Natarajan
		ruleManager = new RuleManager();
		ruleManager.setMockRules();
		//
		accManager.setMockMembers();
		
		
		for (Member m : accManager.members) {
			System.out.println("ID :" + m.getnMemberID() + " | First Name " + m.getMemFname() + "| Email "  + m.getMemEmail());
		}
		
		System.out.println("\nSTATUS: 10 Members created.\n");
		
		System.out.println("*********************************");
		System.out.println("Mocking Up Vehicle...");
		System.out.println("*********************************");
		
		vehManager = new VehicleManager();
		vehManager.setMockVehicles();
		
		for (Vehicle v : vehManager.vehicles) {
			//System.out.println("ID : " +v.vId + " | "  + v.getvDriver());
		}
		
		System.out.println("\nSTATUS: 10 Vehicles created.\n");

		System.out.println("*********************************");
		System.out.println("Mocking Up Ride Request...");
		System.out.println("*********************************");
		
		schManager = new Scheduler(); 
		schManager.setupMockRide(accManager.members);
		
		//System.out.println(schManager.currentRides);
		
		for (Ride v : schManager.currentRides) {
			//System.out.println("ID : " + v.getID() + " | Customer : " + v.getMemberName() + " | From :" + v.getSource() + " | To :" + v.getDestination());
		}
		
		System.out.println("\nSTATUS: 10 Mock Rides ready to be scheduled.\n");
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
	
	public static void addMember() {
		// Scanner inputManager;
		Member newMember = new Customer();
		
		System.out.println("Adding members");
		System.out.println("Adding Member Information");
		System.out.println("Enter Member First Name");
		inputManager = new Scanner(System.in);
		newMember.setMemFname(inputManager.nextLine());
		System.out.println("Enter Member Last Name");
		inputManager = new Scanner(System.in);
		newMember.setMemLname(inputManager.nextLine());
		System.out.println("Enter Member Email");
		inputManager = new Scanner(System.in);
		newMember.setMemEmail(inputManager.nextLine());
		System.out.println("Enter Member Phone Number ");
		inputManager = new Scanner(System.in);
		newMember.setMemPhone(inputManager.nextLine());
		System.out.println("Enter Member Address 1 ");
		inputManager = new Scanner(System.in);
		newMember.setMemAddress1(inputManager.nextLine());
		System.out.println("Enter Member Address 2 ");
		inputManager = new Scanner(System.in);
		newMember.setMemAddress2(inputManager.nextLine());
		System.out.println("Enter City ");
		inputManager = new Scanner(System.in);
		newMember.setMemCity(inputManager.nextLine());
		System.out.println("Enter State ");
		inputManager = new Scanner(System.in);
		newMember.setMemState(inputManager.nextLine());
		System.out.println("Enter Zip ");
		inputManager = new Scanner(System.in);
		newMember.setMemZipcode(inputManager.nextLine());
	   System.out.println("Enter Customer Credit Card Number ");
	   inputManager = new Scanner(System.in);
	   newMember.setMemCreditcard(inputManager.nextLine());
	   System.out.println("Enter CreditCard expiry date - month and 2 digit year MM/YY ");
	   inputManager = new Scanner(System.in);
	   newMember.setMemCreditexpdate(inputManager.nextLine());
	   System.out.println("Enter 3 digit CVV - Creditcard Security code ");
	   inputManager = new Scanner(System.in);
	   newMember.setMemCreditCVV(inputManager.nextLine());
	   System.out.println("Enter Paypal Id: ");
	   inputManager = new Scanner(System.in);
	   newMember.setMemPaypalId(inputManager.nextLine());
		
	  System.out.println("Enter Prime Member Flag ");
	  inputManager = new Scanner(System.in);
	  newMember.setMemRole(inputManager.nextLine()); 
	  System.out.println("Enter Member type: Customer/Driver(C/D)");
	  inputManager = new Scanner(System.in);
	  newMember.setMemType(inputManager.nextLine());

	  accManager.addMembers(newMember);
	  
	  currentUser = newMember;
	  
	  notificationManager.reset();
	  notificationManager.setMessage("New Member Now Logged In." );
	  notificationManager.setListener(currentUser);
	  notificationManager.send();
	  
	  System.out.println("\n ***Welcome " + newMember.getMemFname() + ", \n***");
	  
	}
	
	  public static void addVehicle() {
		    
		    Vehicle newVehicle = new Car();
		    String vDriver;
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
			if (voption == 1){
				newVehicle.setLocation(location);
				newVehicle.setvModel(vModel);
				newVehicle.setvYear(vYear);
				newVehicle.setvIn(vIn);
				newVehicle.setvDriver(vDriver);
				newVehicle.setvHealth(vHealth);
				newVehicle.setVehicleType(vType);
				vehManager.addVehicle(newVehicle);
			}
				
			else{
				newVehicle.setLocation(location);
				newVehicle.setvModel(vModel);
				newVehicle.setvYear(vYear);
				newVehicle.setvIn(vIn);
				newVehicle.setvDriver(vDriver);
				newVehicle.setvHealth(vHealth);
				newVehicle.setVehicleType(vType);
				vehManager.addVehicle(newVehicle);
			}
				

			newVehicle.setVehicleState(new VPending());
			VPending vp = new VPending();
			vp.doAction(newVehicle);
		    
		    /*System.out.println("Adding vehicles");
		    System.out.println("Adding Vehicle Information");
		    System.out.println("Enter Driver");
		    inputVehicle = new Scanner(System.in);
		    newVehicle.setvDriver(inputVehicle.nextLine());
		    
		    
		    newVehicle.setVehicleState(new VPending());
		    
		    System.out.println("Enter Vehicle Model ");
		    inputVehicle = new Scanner(System.in);
		    newVehicle.setvModel(inputVehicle.nextLine());
		    
		    System.out.println("Enter Vehicle Cost");
		    inputVehicle = new Scanner(System.in);
		    newVehicle.setvIn(inputVehicle.nextLine());
		    
		    System.out.println("Enter Vehicle Location");
		    inputVehicle = new Scanner(System.in);
		    newVehicle.setLocation(inputVehicle.nextLine());
		    
		    System.out.println("Enter Vehicle Special features");*/
		    
		    
		    //currentVehicle = newVehicle;
		    
		    
		    
		  }
	
	public static void addRideRequest()
	{
		int noOfRidesToSchedule = 0;
		
		System.out.println("How many rides you want to schedule?");
		inputManager = new Scanner(System.in);
		noOfRidesToSchedule = inputManager.nextInt(); 
		
		System.out.println("---------------------------------------");
		Ride newRide;
		
		notificationManager.reset();
		notificationManager.setListener(currentUser);
		
		for(int i=0;i<noOfRidesToSchedule;i++){
			
			System.out.println("Enter Information for New Ride No." + (i+1) + " of " + noOfRidesToSchedule );
			newRide =new Ride("","","","",null,"","","","");
			System.out.println("Enter Source");
			inputManager = new Scanner(System.in);
			newRide.setSource(inputManager.nextLine());
			System.out.println("Enter Destination");
			inputManager = new Scanner(System.in);
			newRide.setDestination(inputManager.nextLine());
			System.out.println("Enter Date");
			inputManager = new Scanner(System.in);
			newRide.setrideDate(inputManager.nextLine());
			
			newRide.setMember(currentUser);
			//schManager.currentRides.add(newRide);
			schManager.addRide(newRide, currentUser);
			
//			for (Ride r : schManager.currentRides) {
//				System.out.println("TESTING: ID= " + r.getRideID() + " Date= " + r.getDate() + " Source=" + r.getSource());
//			
//			}
			
		}
		
		if(schManager.isEligibileForCoupon(currentUser)){
			
			//notify user
			currentUser.addCoupon("CP");
			notificationManager.setMessage("Hurray! You have earned one coupon.");
		    notificationManager.send();
		    
		    //ask for sharing coupon
		    inputManager = new Scanner(System.in);
			System.out.println("Do you want to share your coupon? [1]Yes [2]No");
			int shareCoupon = inputManager.nextInt();
			
			if(shareCoupon==1){
				inputManager = new Scanner(System.in);
				System.out.println("Enter Member ID to share coupon with");
				String memberIDForCouponShare = inputManager.nextLine();
				boolean memberFound = false;
				//TODO : Check if notifications are received properly!!!
				for(Member m:accManager.members){
					if(m.getnMemberID().equalsIgnoreCase(memberIDForCouponShare)){
						m.receiveCoupon("CP",currentUser);
						memberFound = true;
						break;
					}
				}
				
				if(!memberFound){
					System.out.println("Member with ID " + memberIDForCouponShare + " not found.");
				}else{
					currentUser.removeCoupon();
				}
			}
		}
		
		
		
		System.out.println("All rides to be scheduled...");
		
		for(Ride r:schManager.currentRides){
			schManager.displayRideInfo(r);
		}
		
		//		System.out.println("*********************************");
		//		System.out.println("Scheduling Ride...");
		//		System.out.println("*********************************");
		inputManager = new Scanner(System.in);
		System.out.println("Do you want to schedule all rides now? [1]Yes [2]No");
		String scheduleAllNow = inputManager.nextLine();
		
		if(scheduleAllNow.equalsIgnoreCase("1")){
			scheduleAllRides();
		}
			
	}
	
	public static void scheduleAllRides(){
		
		schManager.carpoolRides(vehManager.vehicles);
	
		List<List<Vertex>> suggestedRoutes;
		ScheduledRide scheduleRideManager;
		for (Ride ride : schManager.currentRides) {
			
			scheduleRideManager = ride.getScheduledRide();
			String source = ride.getSource();
			String destination = ride.getDestination();
			
			//Step:1
			scheduleRideManager.receiveRequest(source,destination);
		
			//Step:2
			suggestedRoutes  = scheduleRideManager.calculateRide(source, destination);
		
			//Step:3
			paymentManager.holdPayment(10, accManager.members);
			
			//Step:4
			//Selecting Shortest Distance Algo By Default
			//Prompt User to choose algorithm - Shortest Distance(0) / Least Time(1)
			scheduleRideManager.dispatchRide(suggestedRoutes,0); 
			
			//Step:5
			paymentManager.proceesPayment(50, ride.getMembers());
			scheduleRideManager.completeRide(10, ride);
		}	
	}
}