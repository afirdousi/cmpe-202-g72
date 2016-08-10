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
	public long custid = 8;
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
	
		member1 = new Customer("Cust002", "James", "LastJames", "James02@yahoo.com", "4085550002", "Cust2 Address1", "Cust2 Address2", "Cust2 City", "Cust2 State", "90002", "Email", "Cash", "1234567890120002", "Y", "PREMIER", "C","10/17","555","james_paypalid");
		members1.add(member1);
		member1 = new Customer("Cust006", "Robert", "Rob6Lname", "Cust06@yahoo.com", "4085550006", "Cust6 Address1", "Cust6 Address2", "Cust6 City", "Cust6 State", "90006", "Email", "Cash", "6234567890120006", "Y", "PREMIER", "C","06/18","666","robert_paypal_id");
		members1.add(member1);
		member1 = new Customer("Cust007", "Jack", "JackLname", "Jack07@yahoo.com", "4085550007", "Cust7 Address1", "Cust7 Address2", "Cust7 City", "Cust7 State", "90007", "Email", "Cash", "7234567890120007", "N", "PREMIER", "C","11/17","777","jack_paypal_id");
		members1.add(member1);
		member1 = new Customer("Cust008", "Barbara", "Cust8Lname", "Cust08@yahoo.com", "4085550008", "Cust8 Address1", "Cust8 Address2", "Cust8 City", "Cust8 State", "90008", "Email", "Cash", "8234567890120008", "Y", "PREMIER", "C","02/18","888","barb_paypal_id");
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
		  System.out.println("Enter Member type: Customer/Sysadmin/Service Provider/Owner(C/S/D/O)");
		  console1 = new Scanner(System.in);
		  strmmemType = (console1.nextLine());

		

	}

	public void addanyMember()

	{

		
		switch (strmmemType) {

		case "C": {
			System.out.println("Member type = " + strmmemType);
			custid++;
			member1 = new Customer("null", "null", "Natar", null, null, null, null, null, null, null, null, null, null,
					null, "PREMIER", "D","null","null","null");
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
			break;
		}

		default: {

			System.out.println("Invalid option");
			break;
		}

		}

	}

}



