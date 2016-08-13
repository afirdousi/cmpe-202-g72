/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/
package com.project.lts.accounts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
 * Author:  Thiagarajan Natarajan
 * Purpose: Client code to show the menu option and get customer information
 * Date: 08/07/2016
 */

public class AccountClient
{

	Scanner console1;
	public long custid = 18;
	public long sysadmid = 2;
	public long sysownerid = 2;
	public long serviceproid = 2;
	public String custID = "1";
	public String strmFName = null;
	public String strmLName = null;
	public String strmEmail = null;
	public String strmPhone = null;
	public String strmAddress1 = null;
	public String strmAddress2 = null;
	public String strmCity = null;
	public String strmState = null;
	public String strmZipcode = null;
	public String strmPrefnotfn = null;
	public String strmPrefpmt = null;
	public String strmCreditcard = null;
	public String strmPrimeflag = null;
	public String strmExpdate=null;
	public String strmCVV = null;
	public String strmPayPalId = null;
	public int choice;
	public String strmmemType = null;
	// Aug 7 morning
	public static List<Member> members1 = new ArrayList<Member>();
	public Customer member1;
	/*public SystemAdmin member2;
	public ServiceProvider member3;
	public SystemOwner member4;*/
	AccountManager mops = new AccountManager();

	public AccountClient(){
		
		
	}

	public void processRequest() {
	
		member1 = new Customer("Cust001", "James", "LastJames", "James01@yahoo.com", "4085550001", "1 Address1", "1 Address2", "SJC", "CA", "95050", "Email", "CreditCard", "1234567890120002", "Y", "PREMIER", "C","10/17","555","james_crcardid");
		members1.add(member1);
		member1 = new Customer("Cust002", "Andy", "LastAndy", "andy01@yahoo.com", "4085550002", "1 Address1", "1 Address2", "SJC", "CA", "95050", "Email", "PayPal", "2234567890120002", "Y", "PREMIER", "C","10/17","555","andy_paypalid");
		members1.add(member1);
		member1 = new Customer("Cust003", "Albert", "LastAlbert", "albert01@yahoo.com", "4085550003", "1 Address1", "1 Address2", "SJC", "CA", "95050", "Email", "CreditCard", "3234567890120002", "Y", "PREMIER", "C","10/17","555","albert_crcardid");
		members1.add(member1);
		member1 = new Customer("Cust004", "Allen", "LastAllen", "allen01@yahoo.com", "4085550004", "1 Address1", "1 Address2", "SJC", "CA", "95050", "Email", "PayPal", "4234567890120002", "Y", "PREMIER", "C","10/17","555","allen_paypalid");
		members1.add(member1);
		member1 = new Customer("Cust005", "Bob", "LastBob", "bob01@yahoo.com", "4085550005", "1 Address1", "1 Address2", "SFO", "CA", "95050", "Email", "CreditCard", "5234567890120002", "Y", "PREMIER", "C","10/17","555","bob_crcardid");
		members1.add(member1);
		member1 = new Customer("Cust006", "Bill", "LastBill", "bill01@yahoo.com", "4085550006", "1 Address1", "1 Address2", "SFO", "CA", "94002", "Email", "PayPal", "6234567890120002", "Y", "PREMIER", "C","10/17","555","bill_paypalid");
		members1.add(member1);
		member1 = new Customer("Cust007", "Charley", "LastCharley", "charley01@yahoo.com", "4085550007", "1 Address1", "1 Address2", "MTV", "CA", "90002", "Email", "PayPal", "7234567890120002", "Y", "PREMIER", "C","10/17","555","charley_paypalid");
		members1.add(member1);
		member1 = new Customer("Cust008", "David", "LastDavid", "david01@yahoo.com", "4085550008", "1 Address1", "1 Address2", "MTV", "CA", "90002", "Email", "CreditCard", "8234567890120002", "Y", "PREMIER", "C","10/17","555","david_crcardid");
		members1.add(member1);
		member1 = new Customer("Cust009", "Donald", "LastDonald", "donlad01@yahoo.com", "4085550009", "1 Address1", "1 Address2", "RWC", "CA", "90002", "Email", "PayPal", "9234567890120002", "Y", "PREMIER", "C","10/17","555","donald_paypalid");
		members1.add(member1);
		member1 = new Customer("Cust0010", "Patricia", "LastPatricia", "patricia01@yahoo.com", "4085550010", "1 Address1", "1 Address2", "RWC", "CA", "90002", "Email", "CreditCard", "1034567890120002", "Y", "PREMIER", "C","10/17","555","patricia_paypalid");
		members1.add(member1);
		
		//Added on Aug 7 2016
		System.out.println("Customers initialized successfully..");


		do {

			System.out.println("Lyft Transportation System (LTS) - Membership Management - SystemAdmin ");
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

			console1 = new Scanner(System.in);
			choice = console1.nextInt();
			console1.nextLine();

			if (choice == 1)

			{
				collectInput();
				addanyMember();
			}



			if (choice == 2) {
				System.out.println("Retrieving Member ");
				System.out.println("Enter Member Id to be retrieved");
				console1 = new Scanner(System.in);
				strmFName = (console1.nextLine());
				mops.retrieveCustomer(strmFName);

			}

			if (choice == 3) {
				System.out.println("Updating Member ");
				System.out.println("Enter Member First Name");
				console1 = new Scanner(System.in);
				strmFName = (console1.nextLine());
				System.out.println("Enter new email address");
				console1 = new Scanner(System.in);
				strmEmail = (console1.nextLine());
				mops.updateCustomer(strmFName, strmEmail);

			}

			if (choice == 4) {
				System.out.println("Removing Member ");
				System.out.println("Enter Member First Name");
				console1 = new Scanner(System.in);
				strmFName = (console1.nextLine());
				mops.removeCustomer(strmFName);
				// print after deletion
				System.out.println("Members list after removing a member ");
				for (int j = 0; j < members1.size(); j++) {
					System.out.println("First Name = " + members1.get(j).memFname + " Member Id = "
							+ members1.get(j).nMemberID + " Member role= " + members1.get(j).memRole);
				}
				// mops.addMembers(member);
				// member.addMembers(member);
			}

			if (choice == 5) {
				System.out.println("Select Member - Enter Member First Name ");
				console1 = new Scanner(System.in);
				strmFName = (console1.nextLine());
				System.out.println("Displaying Selected Member email information ");
				mops.selectCustomer(strmFName);

			}

			if (choice == 6) {
				System.out.println("Search Member based on MemberId ");
				console1 = new Scanner(System.in);
				custID = (console1.nextLine());
				mops.SearchCustomer(custID);

			}

			if (choice == 7) {
				System.out.println("Sorting Members ");

				// Sort members based on their name

				// Collections.sort(members1, new SortComparator());
				mops.sortCustomers();

			}
			if (choice == 8)
				break;

		} while (choice != 9 && choice !=8);


	}

	public void collectInput()

	{
		// Scanner console1;
		System.out.println("Adding members");
		System.out.println("Adding Member Information");
		System.out.println("Enter Member First Name");
		console1 = new Scanner(System.in);
		strmFName = (console1.nextLine());
		System.out.println("Enter Member Last Name");
		console1 = new Scanner(System.in);
		strmLName = (console1.nextLine());
		System.out.println("Enter Member Email");
		console1 = new Scanner(System.in);
		strmEmail = (console1.nextLine());
		System.out.println("Enter Member Phone Number ");
		console1 = new Scanner(System.in);
		strmPhone = (console1.nextLine());
		System.out.println("Enter Member Address 1 ");
		console1 = new Scanner(System.in);
		strmAddress1 = (console1.nextLine());
		System.out.println("Enter Member Address 2 ");
		console1 = new Scanner(System.in);
		strmAddress2 = (console1.nextLine());
		System.out.println("Enter City ");
		console1 = new Scanner(System.in);
		strmCity = (console1.nextLine());
		System.out.println("Enter State ");
		console1 = new Scanner(System.in);
		strmState = (console1.nextLine());
		System.out.println("Enter Zip ");
		console1 = new Scanner(System.in);
		strmZipcode = (console1.nextLine());
		// Added here
		
       
       
		   System.out.println("Enter Customer Credit Card Number ");
		   console1 = new Scanner(System.in);
		   strmCreditcard = (console1.nextLine());
		   System.out.println("Enter CreditCard expiry date - month and 2 digit year MM/YY ");
		   console1 = new Scanner(System.in);
		   strmExpdate = (console1.nextLine());
		   System.out.println("Enter 3 digit CVV - Creditcard Security code ");
		   console1 = new Scanner(System.in);
		   strmCVV = (console1.nextLine());
		   System.out.println("Enter Paypal Id: ");
		   console1 = new Scanner(System.in);
		   strmPayPalId = (console1.nextLine());
		
		  System.out.println("Enter Prime Member Flag ");
		  console1 = new Scanner(System.in);
		  strmPrimeflag = (console1.nextLine());
		  System.out.println("Enter Member type: Customer/Driver(C/D)");
		  console1 = new Scanner(System.in);
		  strmmemType = (console1.nextLine());

		

	}

	public void addanyMember()

	{

		

			System.out.println("Member type = " + strmmemType);
			custid++;
			member1 = new Customer("null", "null", "Natar", null, null, null, null, null, null, null, null, null, null,
					null, "PREMIER", "","null","null","null");
			member1.setnMemberID("Cust00" + custid);
			member1.setMemFname(strmFName);
			member1.setMemLname(strmLName);
			member1.setMemEmail(strmEmail);
			member1.setMemPhone(strmPhone);
			member1.setMemAddress1(strmAddress1);
			member1.setMemAddress2(strmAddress2);
			member1.setMemCity(strmCity);
			member1.setMemState(strmState);
			member1.setMemZipcode(strmZipcode);
			member1.setMemPrefnotfn(strmPrefnotfn);
			member1.setMemPrefpmt(strmPrefpmt);
			member1.setMemCreditcard(strmCreditcard);
			member1.setMemPrimeflag(strmPrimeflag);
			member1.setMemType(strmmemType);
			member1.setMemCreditexpdate(strmExpdate);
			member1.setMemCreditCVV(strmCVV);
			member1.setMemPaypalId(strmPayPalId);
			mops.addMembers(member1, members1);
		


	}

}


