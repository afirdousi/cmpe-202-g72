

import java.util.ArrayList;
import java.util.Scanner;

import com.project.lts.accounts.*;
import com.project.lts.vehicle.*;

public class LTSClient {

	ArrayList<Vehicle> vArr;	
	VehicleClient vehClient;
	AccountClient acctClient;
	
//Aug 7 2016
	LTSClient() {

		this.vehClient = new VehicleClient();
		this.acctClient = new AccountClient();


	}

	public static void main(String args[]) {

		LTSClient lts = new LTSClient();
		// lts.populateData();
		lts.showMainMenu();

	}

	public void populateData() {


		populateVehicleData();

		// TODO Auto-generated method stub

	}

	public void populateVehicleData() {

	}

	public void populateAccountData() {

	}

	private void showMainMenu() {

		System.out.println(" [ ************************************************************************ ]");
		System.out.println(" [ ** Welcome to Lyft Transportation System (LTS) - CMPE 202 Team : G72  ** ]");
		System.out.println(" [ ************************************************************************ ]");
		System.out.println(" [                                                                          ]");
		System.out.println("  >> Please choose your role from the Menu below <<  ");
		System.out.println(" [                                                                          ]");
		System.out.println("[ 1 ] -->  LTS Customer");
		System.out.println("[ 2 ] -->  LTS System Admin");
		System.out.println("[ 3 ] -->  LTS Driver");

		Scanner scan = new Scanner(System.in);
		int choice = Integer.parseInt(scan.nextLine());

		switch (choice) {
		case 1:
			System.out.println("Customer ");
			showCustomerMenu();

			break;
		case 2:
			System.out.println("LTS System Admin");
			showAdminMenu();

			break;

		case 3:

			System.out.println("Driver");
			//showDriverMenu();

			break;

		default:
			System.out.println("Invalid Option .... Please Try Again");
			showMainMenu();
			break;
		}

	}

	private void showDriverMenu() {

		System.out.println("Choose a valid option");

		System.out.println("1 Do Nothing ...");
		System.out.println("2 Return to Main Menu");

		Scanner scan = new Scanner(System.in);
		int choice = Integer.parseInt(scan.nextLine());

		switch (choice) {
		case 1:

			System.out.println("Update Trip Status");
			
			break;
		case 2:
			System.out.println("Return to Main Menu");
			showMainMenu();

			break;

		default:
			System.out.println("Invalid Option .... Please Try Again");
			showDriverMenu();
			break;
		}

	}

	private void showAdminMenu() {
        int choice=0;
        while (choice !=5) {
		System.out.println("Choose a valid option");
		System.out.println("1 CRUD Account");
		System.out.println("2 CRUD Rule");
		System.out.println("3 CRUD Vehicle");
		System.out.println("4 Return to Main Menu");
		System.out.println("5 Exit");
       
        	Scanner scan = new Scanner(System.in);
    		choice = Integer.parseInt(scan.nextLine());
       
		switch (choice) {
		case 1:
			System.out.println("CRUD Account");
			acctClient.processRequest();
			// invoke account client

			break;
		case 2:
			// System.out.println("CRUD Rule");
			// scClient.processRuleRequest();
			// invoke rule manager

			break;
		case 3:
			System.out.println("CRUD Vehicle");
			vehClient.manageVehicle();
			break;
		
		case 4:
			System.out.println("Return to Main Menu");
			showMainMenu();
			break;
		case 5:
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid Option .... Please Try Again");
			showAdminMenu();
			break;

		} //switch
     }//while
	}
	// TODO Auto-generated method stub

	private void showCustomerMenu() {

		// init()

		System.out.println("Choose a valid option");
		System.out.println("1 CRUD Account");

		System.out.println("2 Request Ride");

		System.out.println("3 Return to Main Menu");
		System.out.println("4 Exit");

		Scanner scan = new Scanner(System.in);
		int choice = Integer.parseInt(scan.nextLine());

		switch (choice) {
		case 1:
			System.out.println("Create an Account");

			 acctClient.processRequest();

		case 2:
			System.out.println("Request Ride");
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
			showCustomerMenu();
			break;
		}

		// TODO Auto-generated method stub

	}

}