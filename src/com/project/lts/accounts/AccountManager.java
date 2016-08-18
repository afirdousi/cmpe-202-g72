/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.accounts;

/**
 * 
 * Author:  Thiagarajan Natarajan
 * Purpose: Member CRUD operations
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import com.project.lts.accounts.*;
import com.project.lts.notification.Notification;

public class AccountManager {

	Customer cs;
	public  ArrayList<Member> members;
	public Member member;
    public Notification notificationManager = new Notification();
    
    public Scanner console1;
	public long customerCount = 10;
//	public long sysadmid = 2;
//	public long sysownerid = 2;
//	public long serviceproid = 2;
//	public String custID = "1";
//	public String strmFName = null;
//	public String strmLName = null;
//	public String strmEmail = null;
//	public String strmPhone = null;
//	public String strmAddress1 = null;
//	public String strmAddress2 = null;
//	public String strmCity = null;
//	public String strmState = null;
//	public String strmZipcode = null;
//	public String strmPrefnotfn = null;
//	public String strmPrefpmt = null;
//	public String strmCreditcard = null;
//	public String strmPrimeflag = null;
//	public String strmExpdate=null;
//	public String strmCVV = null;
//	public String strmPayPalId = null;
//	public int choice;
//	public String strmmemType = null;
    
    //
	public AccountManager() {
		this.members = new ArrayList<Member>();
	}

	public void setMockMembers() {
		
		member = new Customer("1", "James", "LastJames", "James01@yahoo.com", "4085550001", "1 Address1",
				"1 Address2", "SJC", "CA", "95050", "Email", "CreditCard", "1234567890120002", "Y", "PREMIER", "C",
				"10/17", "555", "james_crcardid");
		
		members.add(member);
		
		member = new Customer("2", "Andy", "LastAndy", "andy01@yahoo.com", "4085550002", "1 Address1",
				"1 Address2", "SJC", "CA", "95050", "Email", "PayPal", "2234567890120002", "Y", "", "C", "10/17",
				"555", "andy_paypalid");
		members.add(member);
		
		member = new Customer("3", "Albert", "LastAlbert", "albert01@yahoo.com", "4085550003", "1 Address1",
				"1 Address2", "SJC", "CA", "95050", "Email", "CreditCard", "3234567890120002", "Y", "PREMIER", "C",
				"10/17", "555", "albert_crcardid");
		members.add(member);
		
		member = new Customer("4", "Allen", "LastAllen", "allen01@yahoo.com", "4085550004", "1 Address1",
				"1 Address2", "SJC", "CA", "95050", "Email", "PayPal", "4234567890120002", "Y", "PREMIER", "C", "10/17",
				"555", "allen_paypalid");
		members.add(member);
		
		member = new Customer("5", "Bob", "LastBob", "bob01@yahoo.com", "4085550005", "1 Address1", "1 Address2",
				"SFO", "CA", "95050", "Email", "CreditCard", "5234567890120002", "Y", "PREMIER", "C", "10/17", "555",
				"bob_crcardid");
		members.add(member);
		
		member = new Customer("6", "Bill", "LastBill", "bill01@yahoo.com", "4085550006", "1 Address1",
				"1 Address2", "SFO", "CA", "94002", "Email", "PayPal", "6234567890120002", "Y", "PREMIER", "C", "10/17",
				"555", "bill_paypalid");
		members.add(member);
		
		member = new Customer("7", "Charley", "LastCharley", "charley01@yahoo.com", "4085550007", "1 Address1",
				"1 Address2", "MTV", "CA", "90002", "Email", "PayPal", "7234567890120002", "Y", "PREMIER", "C", "10/17",
				"555", "charley_paypalid");
		members.add(member);
		
		member = new Customer("8", "David", "LastDavid", "david01@yahoo.com", "4085550008", "1 Address1",
				"1 Address2", "MTV", "CA", "90002", "Email", "CreditCard", "8234567890120002", "Y", "PREMIER", "C",
				"10/17", "555", "david_crcardid");
		members.add(member);
		
		member = new Customer("9", "Donald", "LastDonald", "donlad01@yahoo.com", "4085550009", "1 Address1",
				"1 Address2", "RWC", "CA", "90002", "Email", "PayPal", "9234567890120002", "Y", "PREMIER", "C", "10/17",
				"555", "donald_paypalid");
		members.add(member);
		
		member = new Customer("10", "Patricia", "LastPatricia", "patricia01@yahoo.com", "4085550010",
				"1 Address1", "1 Address2", "RWC", "CA", "90002", "Email", "CreditCard", "1034567890120002", "Y",
				"", "C", "10/17", "555", "patricia_paypalid");
		members.add(member);
		

	}

	public void addMembers(Member m)
	{
        //System.out.println("In addMembers method -- Is member list empty"+members.isEmpty());
	
        //if (!members.isEmpty()) {
			customerCount++;
			
			m.setnMemberID(Long.toString(customerCount));
			
			members.add(m);
			
			notificationManager.reset();
			notificationManager.setListener(m);
			notificationManager.setMessage("Member Notified   "+m.getMemEmail());
			notificationManager.send();
			//System.out.println("After adding the size of the members arraylist = " + members.size());
			for (int i = 0; i < members.size(); i++)
			{

				System.out.println("\n" + members.get(i).getnMemberID() + " " +  members.get(i).getMemFname() + " * "
						+  members.get(i).getMemLname() + " * " +  members.get(i).getMemEmail() + " * "
						+  members.get(i).getMemPhone() + " * " +  members.get(i).getMemRole() + " Member type= "
						+  members.get(i).getMemType());

			}
		//}

	}

	public void removeCustomer(String memberID) {
		{

			boolean memberFound = false;
			//System.out.println("Printing after deletion..");

			for (Member m:members) {
				if (m.getnMemberID().equalsIgnoreCase(memberID)) {
					
					memberFound = true;
					notificationManager.reset();
					notificationManager.setListener(m);
					notificationManager.setMessage("Member with ID " + memberID + " deleted successfully");
					notificationManager.send();
					
					members.remove(m);
					break;
				}
			}
//			System.out.println("Member has been deleted successfully!");
//			System.out.println("Size of the list after delete operation is " + members.size());
			if(!memberFound){
				System.out.println("Member with ID : " + memberID + " not found.");
			}
			
		}

	}

//	public Member retrieveCustomer(String memberId) {
//		boolean retflag = false;
//		System.out.println("Printing after retrieving ..");
//
//		for (int i = 0; i < members.size() && !retflag; i++) {
//
//			if (members.get(i).getnMemberID().equalsIgnoreCase(memberId)) {
//				//
//				System.out.println("\n" + members.get(i).getnMemberID() + " " + members.get(i).getMemFname()
//						+ " * " + members.get(i).getMemLname() + " * " + members.get(i).getMemEmail() + " * "
//						+ members.get(i).getMemPhone() + " * " + members.get(i).getMemCreditcard() + " * "
//						+ members.get(i).getMemPaypalId() + " * " +members.get(i).getMemRole());
//
//				return members.get(i);
//
//				
//			}
//			//
//			//
//			//
//		}
//
//		return null;
//
//	}

	public void SearchCustomer(String CustId) {
		// TODO implement me
		System.out.println("Printing after Searching..");
		boolean foundflag = false;
		System.out.println("Array size = " + members.size());
		for (int i = 0; i < members.size() && !foundflag; i++) {

			if (members.get(i).getnMemberID().equalsIgnoreCase(CustId)) {
				System.out.println("Member found\n" + CustId);
				foundflag = true;
				System.out.println("Member details Searched " + members.get(i).memFname + " "
						+ members.get(i).getMemEmail());
				// this.members.get(i).memFname= CustFName;
			}

		}
		if (!foundflag) {
			System.out.println("Member is not found..Pl enter correct member ID");
			foundflag = true;
		}
		//
	}

	public void updateCustomer(String ID, String firstName, String email) {
		
		boolean	updated = false;
		
		
		for(Member m:members){
			if(m.getnMemberID().equalsIgnoreCase(ID)){
				m.setMemFname(firstName);
				m.setMemEmail(email);
				updated =true;
				
				notificationManager.reset();
				notificationManager.setListener(m);
				notificationManager.setMessage("Member with ID = "+ m.getnMemberID() +  " updated successfully");
				notificationManager.send();
				displayMember(m);
			}
		}
		
		if(!updated){
			System.out.println("Member with ID " + ID + " not found");
		}
		
		
		// TODO implement me
		// This method is used to retrieve a member from the array
//		{

//			m.setMemFname(firstName);

//			for (int i = 0; i < members.size() && !updtflag; i++) {

//				if (members.get(i).getMemFname().equalsIgnoreCase(firstName)) {
//
//					members.get(i).memEmail = email;
//					updtflag = true;
//					System.out.println("Member Email Updated for " + members.get(i).memFname + " "
//							+ members.get(i).memEmail);
//					System.out.println("Member has been updated successfully!");
//				}

//			}
//			if (!updtflag)
//				System.out.println("Member not found.. Pl enter correct customer first name");
				
//		}

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void sortCustomers()

	{
		boolean retflag = false;

		//Collections.sort(this.members, new SortComparator());
		Collections.sort(members, new SortComparator());
		System.out.println("Sorted list ");
		for (Member e : members) {
			System.out.println("Member ID " + e.getnMemberID());
			System.out.println("Member First Name " + e.getMemFname());
			System.out.println("Member Email " + e.getMemEmail());

		}

	}

	public void selectCustomer(String CustFName)

	{
		boolean selectflag = false;
		System.out.println("Printing after selecting ..");

		for (int i = 0; i < members.size() && !selectflag; i++) {

			if (members.get(i).getMemFname().equalsIgnoreCase(CustFName)) {
				selectflag = true;
				System.out.println(
						"Selected Member * " + CustFName + " * Email address is *  " + members.get(i).memEmail);
				// this.members.get(i).memFname= CustFName;
			}

		}
		if (selectflag)
			System.out.println("Member has been selected successfully!");
		else
			System.out.println("Member not found to select.. Pl enter correct membername");

	}

	public void retrieveMember(String memberId) {
		
		boolean memberFound = false;
		for (Member m : members) {
			
			if (m.getnMemberID().equalsIgnoreCase(memberId)) {
				displayMember(m);
				memberFound =true;
				break;
			}

		}

		if(!memberFound){
			System.out.println("No member found for ID = " + memberId);
		}

	}
	
	public void displayMember(Member m){
		
		System.out.println("\n" + m.getnMemberID() + " " + m.getMemFname()
				+ " * " + m.getMemLname() + " * " + m.getMemEmail() + " * "
				+ m.getMemPhone() + " * " + m.getMemCreditcard() + " * "
				+ m.getMemPaypalId() + " * " +m.getMemRole());
		
	}
	
//	public void showAccountmenu() {
//		
//		
//		
//	
//		do {
//
//			System.out.println("Lyft Transportation System (LTS) - Membership Management - SystemAdmin ");
//			System.out.println("=============================================================");
//			System.out.println("1. Add Member");
//			System.out.println("2. Retrieve Member");
//			System.out.println("3. Update Member");
//			System.out.println("4. Delete Members");
//			System.out.println("5. Select Members");
//			System.out.println("6. Search Members");
//			System.out.println("7. Sort Members");
//			System.out.println("8. Back");
//			System.out.println("9. Exit");
//			System.out.println("Enter your option(1,2,3,4,5,6,7,8,9)");
//
//			console1 = new Scanner(System.in);
//			choice = console1.nextInt();
//			console1.nextLine();
//
//			if (choice == 1)
//
//			{
//				collectInput();
//				addanyMember();
//			}
//
//
//
//			if (choice == 2) {
//				System.out.println("Retrieving Member ");
//				System.out.println("Enter Member Id to be retrieved");
//				console1 = new Scanner(System.in);
//				strmFName = (console1.nextLine());
//				retrieveCustomer(strmFName);
//			
//
//			}
//
//			if (choice == 3) {
//				System.out.println("Updating Member ");
//				System.out.println("Enter Member First Name");
//				console1 = new Scanner(System.in);
//				strmFName = (console1.nextLine());
//				System.out.println("Enter new email address");
//				console1 = new Scanner(System.in);
//				strmEmail = (console1.nextLine());
//				updateCustomer(strmFName, strmEmail);
//
//			}
//
//			if (choice == 4) {
//				System.out.println("Removing Member ");
//				System.out.println("Enter Member First Name");
//				console1 = new Scanner(System.in);
//				strmFName = (console1.nextLine());
//			    removeCustomer(strmFName);
//				// print after deletion
//				System.out.println("Members list after removing a member ");
//				for (int j = 0; j < members.size(); j++) {
//					System.out.println("First Name = " + members.get(j).memFname + " Member Id = "
//							+ members.get(j).nMemberID + " Member role= " + members.get(j).memRole);
//				}
//				// mops.addMembers(member);
//				// member.addMembers(member);
//			}
//
//			if (choice == 5) {
//				System.out.println("Select Member - Enter Member First Name ");
//				console1 = new Scanner(System.in);
//				strmFName = (console1.nextLine());
//				System.out.println("Displaying Selected Member email information ");
//				selectCustomer(strmFName);
//
//			}
//
//			if (choice == 6) {
//				System.out.println("Search Member based on MemberId ");
//				console1 = new Scanner(System.in);
//				custID = (console1.nextLine());
//			    SearchCustomer(custID);
//
//			}
//
//			if (choice == 7) {
//				System.out.println("Sorting Members ");
//
//				// Sort members based on their name
//
//				// Collections.sort(members1, new SortComparator());
//			   sortCustomers();
//
//			}
//			if (choice == 8)
//				break;
//
//		} while (choice != 9 && choice !=8);
//
//
//	}
//
//	public void collectInput()
//
//	{
//		// Scanner console1;
//		System.out.println("Adding members");
//		System.out.println("Adding Member Information");
//		System.out.println("Enter Member First Name");
//		console1 = new Scanner(System.in);
//		strmFName = (console1.nextLine());
//		System.out.println("Enter Member Last Name");
//		console1 = new Scanner(System.in);
//		strmLName = (console1.nextLine());
//		System.out.println("Enter Member Email");
//		console1 = new Scanner(System.in);
//		strmEmail = (console1.nextLine());
//		System.out.println("Enter Member Phone Number ");
//		console1 = new Scanner(System.in);
//		strmPhone = (console1.nextLine());
//		System.out.println("Enter Member Address 1 ");
//		console1 = new Scanner(System.in);
//		strmAddress1 = (console1.nextLine());
//		System.out.println("Enter Member Address 2 ");
//		console1 = new Scanner(System.in);
//		strmAddress2 = (console1.nextLine());
//		System.out.println("Enter City ");
//		console1 = new Scanner(System.in);
//		strmCity = (console1.nextLine());
//		System.out.println("Enter State ");
//		console1 = new Scanner(System.in);
//		strmState = (console1.nextLine());
//		System.out.println("Enter Zip ");
//		console1 = new Scanner(System.in);
//		strmZipcode = (console1.nextLine());
//		// Added here
//		
//       
//       
//		   System.out.println("Enter Customer Credit Card Number ");
//		   console1 = new Scanner(System.in);
//		   strmCreditcard = (console1.nextLine());
//		   System.out.println("Enter CreditCard expiry date - month and 2 digit year MM/YY ");
//		   console1 = new Scanner(System.in);
//		   strmExpdate = (console1.nextLine());
//		   System.out.println("Enter 3 digit CVV - Creditcard Security code ");
//		   console1 = new Scanner(System.in);
//		   strmCVV = (console1.nextLine());
//		   System.out.println("Enter Paypal Id: ");
//		   console1 = new Scanner(System.in);
//		   strmPayPalId = (console1.nextLine());
//		
//		  System.out.println("Enter Prime Member Flag ");
//		  console1 = new Scanner(System.in);
//		  strmPrimeflag = (console1.nextLine());
//		  System.out.println("Enter Member type: Customer/Driver(C/D)");
//		  console1 = new Scanner(System.in);
//		  strmmemType = (console1.nextLine());
//
//		
//
//	}

//	public void addanyMember()
//
//	{
//
//		
//
//			System.out.println("Member type = " + strmmemType);
//			custid++;
//			member = new Customer("null", "null", "Natar", null, null, null, null, null, null, null, null, null, null,
//					null, "PREMIER", "","null","null","null");
//			member.setnMemberID("Cust00" + custid);
//			member.setMemFname(strmFName);
//			member.setMemLname(strmLName);
//			member.setMemEmail(strmEmail);
//			member.setMemPhone(strmPhone);
//			member.setMemAddress1(strmAddress1);
//			member.setMemAddress2(strmAddress2);
//			member.setMemCity(strmCity);
//			member.setMemState(strmState);
//			member.setMemZipcode(strmZipcode);
//			member.setMemPrefnotfn(strmPrefnotfn);
//			member.setMemPrefpmt(strmPrefpmt);
//			member.setMemCreditcard(strmCreditcard);
//			member.setMemPrimeflag(strmPrimeflag);
//			member.setMemType(strmmemType);
//			member.setMemCreditexpdate(strmExpdate);
//			member.setMemCreditCVV(strmCVV);
//			member.setMemPaypalId(strmPayPalId);
//			addMembers(member, members);
//		
//
//
//	}
	

}
