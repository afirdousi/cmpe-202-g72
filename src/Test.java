import java.util.*;

import com.project.lts.accounts.*;
import com.project.lts.notification.Notification;
import java.io.IOException;

import java.io.*;

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
		System.out.println("|----------------------Lyft Ride Management System-------------------------|");
		System.out.println("|--------------------------------------------------------------------------|");
	}

	public static void renderMainMenu(){
		renderHeader();
		System.out.println("\n");
		System.out.println("\t[1] Sign Up \t\t [2] Login \t\t [3] Close");
	}

	public static void renderSignUpMenu(){
		renderHeader();
		System.out.println("\n");
		System.out.println("\t[1] Home \t\t [2] Profile \t\t [3] Update Profile \n  \t[4] Schedule Ride\t\t[5] My Rides\t\t[6]Reports");
	}
	
	public static void renderLogin(){
		renderHeader();
		System.out.println("\n");
		System.out.println("\t[1] Home \t\t [2] Profile \t\t [3] Update Profile \n  \t[4] Schedule Ride\t\t[5] My Rides\t\t[6]Reports");
	}
	
	public static void renderMemberMenu(){

		renderHeader();
		System.out.println("\n");
		System.out.println("\t[1] Home \t\t [2] Profile \t\t [3] Update Profile \n  \t[4] Schedule Ride\t\t[5] My Rides\t\t[6]Reports");
	}
	
	public static void renderVehicleMenu(){

		renderHeader();
		System.out.println("\n");
		System.out.println("\t[1] Home \t\t [2] Profile \t\t [3] Update Profile \n  \t[4] Schedule Ride\t\t[5] My Rides\t\t[6]Reports");
	}
	
	public static void renderScheduleMenu(){

		renderHeader();
		System.out.println("\n");
		System.out.println("\t[1] Home \t\t [2] Profile \t\t [3] Update Profile \n  \t[4] Schedule Ride\t\t[5] My Rides\t\t[6]Reports");
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
	
	public static void main(String[] args) throws IOException {
		
		STATE state = STATE.MAIN_MENU;
		
		renderMainMenu();
		Scanner scanchoice = new Scanner(System.in);
		System.out.println();
		int selectedMenu = scanchoice.nextInt();
		while (selectedMenu != 3) {
			
//			MAIN_MENU,
//			SIGN_UP,
//			LOGIN,
//			MEMBER_MENU,
//			VEHICLE_MENU,
//			SCHEDULE_MENU,
//			GUEST,
//			USER
			
			switch(selectedMenu){
			case 1:
				state = STATE.SIGN_UP;
				render(STATE.SIGN_UP);
				selectedMenu = scanchoice.nextInt();
				break;
			case 2:
				state = STATE.LOGIN;
				render(STATE.LOGIN);	
				break;
			case 3:
				state = STATE.MEMBER_MENU;
				render(STATE.MEMBER_MENU);	break;
			case 4:
				state = STATE.MEMBER_MENU;
				render(STATE.VEHICLE_MENU);	
				break;
			case 5:
				state = STATE.MEMBER_MENU;
				render(STATE.SCHEDULE_MENU);	
				break;
			case 6:render(STATE.GUEST);	break;
			case 7:render(STATE.USER);	break;
			
			
			//System.out.println("What you want to do next?");
			

		}   
		
		
		
		
		
	   
//		Notification notfication = new Notification();
//		
//		Member m1 = new Member();
//		m1.setName("Srinath Jagganath");
//		m1.setPhoneNumber("562-682-4406");
//		m1.setEmail("sjsrinath92@gmail.com");
//		
//		Member m2 = new Member();
//		m2.setName("Sumit Mendiratta");
//		m2.setPhoneNumber("669-232-7803");
//		m2.setEmail("sumit.mendiratta@gmail.com");
//		
//		Member m3 = new Member();
//		m3.setName("Anas Raza Firdousi");
//		m3.setPhoneNumber("408-816-4966");
//		m3.setEmail("anas.firdousi@gmail.com");
//		
//		//TEST:01
//		System.out.println("TEST 001");
//		System.out.println("*********");
//		
//		notfication.setMessage("Driver waiting outside");
//		notfication.setListener(m1);
//		notfication.setListener(m2);
//		notfication.send();
//		
//		//TEST:02
//		
//		System.out.println("TEST 002");
//		System.out.println("*********");
//		
//		notfication.setMessage("Payment received");
//		notfication.removeListener(m1);
//		
//		notfication.send();
//		
//		//TEST:03
//		System.out.println("TEST 003");
//		System.out.println("*********");
//		
//		notfication.resetListeners();
//		notfication.setListener(m3);
//		notfication.setMessage("Ride complete!");
//		
//		notfication.send();

		
		
//	    System.out.println(" Welcome to CarPool app");
//	    System.out.println(" What you would like to do?");
//	    System.out.println(" (S) Signup (L) Login");
//	    
//	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Enter Your Choice?");
//        String s = br.readLine();
//	    System.out.println(s);
//
//	    if(s.equals("S"))
//	    {
//	       System.out.println("Would you like to signup as (R)rider or (D)driver?            (O)SignOut ");
//	       System.out.println("Enter your choice?");
//	       String sc = br.readLine();
//	       if(sc.equals("S"))
//	       {
//	    	   System.out.println("Entered is Rider");
//	    	   System.out.println("Entered User Name ");
//	    	   String uername = br.readLine();
//	    	   System.out.println("Entered Email ID");
//	    	   String emailid = br.readLine();
//	    	   System.out.println("Entered Passowrd");
//	    	   String password = br.readLine();
//	    	   System.out.println("Entered Contact Number");
//	    	   String contactnumber = br.readLine();
//	    	   System.out.println("Entered Address");
//	    	   String addr = br.readLine();
//	    	   System.out.println("Entere Driving License Number");
//	    	   String dl = br.readLine();
//	    	   
//	    	   List list  = new ArrayList();
//		 	   list.add(uername);
//		 	   list.add(emailid);
//		 	   list.add(password);
//		 	   list.add(contactnumber);
//		 	   list.add(addr);
//		 	   list.add(dl);
//		 	
//		 	   System.out.println(list);
//	    	   
//	    	 }
//	       else{
//	    	   
//	    	   System.out.println("Entered is Driver");
//	    	   System.out.println("Entered is Rider");
//	    	   System.out.println("Entered User Name ");
//	    	   String uername = br.readLine();
//	    	   System.out.println("Entered Email ID");
//	    	   String emailid = br.readLine();
//	    	   System.out.println("Entered Passowrd");
//	    	   String password = br.readLine();
//	    	   System.out.println("Entered Contact Number");
//	    	   String contactnumber = br.readLine();
//	    	   System.out.println("Entered Address");
//	    	   String addr = br.readLine();
//	       }
//	       
//	       
//	    }
//	    else if(s.equals("L"))
//	    {
//	    	 System.out.println("Enter User Name");
//	    	 String uername = br.readLine();
//	    	 System.out.println("Enter Password");
//	    	 String pwd = br.readLine();
//	    	 
//	 
//	  
//	    	 
//	    }
//	    else{
//	    	System.out.println("Wrong Choice");
//	    }
//	    
	    
	    
	    
	    
	}
	}
}
