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
		System.out.println("Sing Up\n \n");
		System.out.println("\t[1] Home \t\t [2] Profile \t\t [3] Update Profile \n  \t[4] Schedule Ride\t [5] My Rides\t\t [6]Reports");
		//System.out.println("\t[1] Home \t\t \n\n Enter Pickup Location: \n\n Enter Dropoff Location: \n\n Enter Type of Car: \n\n Enter No. of Seats: \n\n Do you need infant seat?[Y/N]: \n\n Enter \n\n Enter ");
		//System.out.println("\t[1] Home  \n\n \t 001 \t 8/10/2016\t SJC\t SFO\t $10.00 \n\t 002 \t 8/9/2016\t SJC\t RDC\t $27.00 \n\t 003 \t 8/9/2016\t SJC\t RCT\t $42.00 ");
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
	

}
