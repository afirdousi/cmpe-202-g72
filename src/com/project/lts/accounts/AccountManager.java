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
	public ArrayList<Member> members;
	public Member member;
    public Notification notificationManager = new Notification();
	public AccountManager() {
		this.members = new ArrayList<Member>();
	}
//Aug 13 2016 modifying members to members1
	public void setMockMembers() {
		
		member = new Customer("Cust001", "James", "LastJames", "James01@yahoo.com", "4085550001", "1 Address1",
				"1 Address2", "SJC", "CA", "95050", "Email", "CreditCard", "1234567890120002", "Y", "PREMIER", "C",
				"10/17", "555", "james_crcardid");
		
		members.add(member);
		
		member = new Customer("Cust002", "Andy", "LastAndy", "andy01@yahoo.com", "4085550002", "1 Address1",
				"1 Address2", "SJC", "CA", "95050", "Email", "PayPal", "2234567890120002", "Y", "PREMIER", "C", "10/17",
				"555", "andy_paypalid");
		members.add(member);
		
		member = new Customer("Cust003", "Albert", "LastAlbert", "albert01@yahoo.com", "4085550003", "1 Address1",
				"1 Address2", "SJC", "CA", "95050", "Email", "CreditCard", "3234567890120002", "Y", "PREMIER", "C",
				"10/17", "555", "albert_crcardid");
		members.add(member);
		
		member = new Customer("Cust004", "Allen", "LastAllen", "allen01@yahoo.com", "4085550004", "1 Address1",
				"1 Address2", "SJC", "CA", "95050", "Email", "PayPal", "4234567890120002", "Y", "PREMIER", "C", "10/17",
				"555", "allen_paypalid");
		members.add(member);
		
		member = new Customer("Cust005", "Bob", "LastBob", "bob01@yahoo.com", "4085550005", "1 Address1", "1 Address2",
				"SFO", "CA", "95050", "Email", "CreditCard", "5234567890120002", "Y", "PREMIER", "C", "10/17", "555",
				"bob_crcardid");
		members.add(member);
		
		member = new Customer("Cust006", "Bill", "LastBill", "bill01@yahoo.com", "4085550006", "1 Address1",
				"1 Address2", "SFO", "CA", "94002", "Email", "PayPal", "6234567890120002", "Y", "PREMIER", "C", "10/17",
				"555", "bill_paypalid");
		members.add(member);
		
		member = new Customer("Cust007", "Charley", "LastCharley", "charley01@yahoo.com", "4085550007", "1 Address1",
				"1 Address2", "MTV", "CA", "90002", "Email", "PayPal", "7234567890120002", "Y", "PREMIER", "C", "10/17",
				"555", "charley_paypalid");
		members.add(member);
		
		member = new Customer("Cust008", "David", "LastDavid", "david01@yahoo.com", "4085550008", "1 Address1",
				"1 Address2", "MTV", "CA", "90002", "Email", "CreditCard", "8234567890120002", "Y", "PREMIER", "C",
				"10/17", "555", "david_crcardid");
		members.add(member);
		
		member = new Customer("Cust009", "Donald", "LastDonald", "donlad01@yahoo.com", "4085550009", "1 Address1",
				"1 Address2", "RWC", "CA", "90002", "Email", "PayPal", "9234567890120002", "Y", "PREMIER", "C", "10/17",
				"555", "donald_paypalid");
		members.add(member);
		
		member = new Customer("Cust0010", "Patricia", "LastPatricia", "patricia01@yahoo.com", "4085550010",
				"1 Address1", "1 Address2", "RWC", "CA", "90002", "Email", "CreditCard", "1034567890120002", "Y",
				"PREMIER", "C", "10/17", "555", "patricia_paypalid");
		members.add(member);
		

	}

	public void addMembers(Member m, List<Member> members)
	// This method add members to Member array members
	{
        System.out.println("In addMembers method -- Is member list empty"+AccountClient.members1.isEmpty());
		if (!AccountClient.members1.isEmpty()) {

			//members.add(m);
			//Aug 13 2016 Added 
			AccountClient.members1.add(m);
			//Aug 13 2016 Observer pattern changes Notification
			notificationManager.reset();

			notificationManager.setListener(m);

			notificationManager.setMessage("Member Notified   "+m.getMemEmail());
			notificationManager.send();
			System.out.println("After adding the size of the members arraylist = " + AccountClient.members1.size());

			// sortMembers(members);
			for (int i = 0; i < AccountClient.members1.size(); i++)

			{

				System.out.println("\n" + AccountClient.members1.get(i).getnMemberID() + " " +  AccountClient.members1.get(i).getMemFname() + " * "
						+  AccountClient.members1.get(i).getMemLname() + " * " +  AccountClient.members1.get(i).getMemEmail() + " * "
						+  AccountClient.members1.get(i).getMemPhone() + " * " +  AccountClient.members1.get(i).getMemRole() + " Member type= "
						+  AccountClient.members1.get(i).getMemType());
				// System.out.println(members.get(i).getMemLname());

			}
		} // if

	} // method end

	public void removeCustomer(String CustFName) {
		// TODO implement me
		// This method is used to delete a member from the array
		{

			System.out.println("Printing after deletion..");

			for (int i = 0; i < AccountClient.members1.size(); i++) {

				if (AccountClient.members1.get(i).getMemFname().equalsIgnoreCase(CustFName)) {
					System.out.println("Member First name in delete " + AccountClient.members1.get(i).memFname);
					AccountClient.members1.remove(i);
				}

			}
			System.out.println("Member has been deleted successfully!");
			System.out.println("Size of the list after delete operation is " + AccountClient.members1.size());
		}

	}

	public Member retrieveCustomer(String memberId) {
		boolean retflag = false;
		System.out.println("Printing after retrieving ..");

		for (int i = 0; i < AccountClient.members1.size() && !retflag; i++) {

			if (AccountClient.members1.get(i).getnMemberID().equalsIgnoreCase(memberId)) {
				//
				System.out.println("\n" + AccountClient.members1.get(i).getnMemberID() + " " + AccountClient.members1.get(i).getMemFname()
						+ " * " + AccountClient.members1.get(i).getMemLname() + " * " + AccountClient.members1.get(i).getMemEmail() + " * "
						+ AccountClient.members1.get(i).getMemPhone() + " * " + AccountClient.members1.get(i).getMemCreditcard() + " * "
						+ AccountClient.members1.get(i).getMemPaypalId() + " * " +AccountClient.members1.get(i).getMemRole());

				return AccountClient.members1.get(i);

				
			}
			//
			//
			//
		}

		return null;

	}

	public void SearchCustomer(String CustId) {
		// TODO implement me
		System.out.println("Printing after Searching..");
		boolean foundflag = false;
		System.out.println("Array size = " + AccountClient.members1.size());
		for (int i = 0; i < AccountClient.members1.size() && !foundflag; i++) {

			if (AccountClient.members1.get(i).getnMemberID().equalsIgnoreCase(CustId)) {
				System.out.println("Member found\n" + CustId);
				foundflag = true;
				System.out.println("Member details Searched " + AccountClient.members1.get(i).memFname + " "
						+ AccountClient.members1.get(i).getMemEmail());
				// this.members.get(i).memFname= CustFName;
			}

		}
		if (!foundflag) {
			System.out.println("Member is not found..Pl enter correct member ID");
			foundflag = true;
		}
		//
	}

	public void updateCustomer(String CustFName, String CEmail) {
		// TODO implement me
		// This method is used to retrieve a member from the array
		{

			boolean updtflag = false;

			for (int i = 0; i < AccountClient.members1.size() && !updtflag; i++) {

				if (AccountClient.members1.get(i).getMemFname().equalsIgnoreCase(CustFName)) {

					AccountClient.members1.get(i).memEmail = CEmail;
					updtflag = true;
					System.out.println("Member Email Updated for " + AccountClient.members1.get(i).memFname + " "
							+ AccountClient.members1.get(i).memEmail);
					System.out.println("Member has been updated successfully!");
				}

			}
			if (!updtflag)
				System.out.println("Member not found.. Pl enter correct customer first name");
		}

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
		Collections.sort(AccountClient.members1, new SortComparator());
		System.out.println("Sorted list ");
		for (Member e : AccountClient.members1) {
			System.out.println("Member ID " + e.getnMemberID());
			System.out.println("Member First Name " + e.getMemFname());
			System.out.println("Member Email " + e.getMemEmail());

		}

	}

	public void selectCustomer(String CustFName)

	{
		boolean selectflag = false;
		System.out.println("Printing after selecting ..");

		for (int i = 0; i < AccountClient.members1.size() && !selectflag; i++) {

			if (AccountClient.members1.get(i).getMemFname().equalsIgnoreCase(CustFName)) {
				selectflag = true;
				System.out.println(
						"Selected Member * " + CustFName + " * Email address is *  " + AccountClient.members1.get(i).memEmail);
				// this.members.get(i).memFname= CustFName;
			}

		}
		if (selectflag)
			System.out.println("Member has been selected successfully!");
		else
			System.out.println("Member not found to select.. Pl enter correct membername");

	}

	public Member retrieveMember(String memberId) {

		for (Member m : AccountClient.members1) {

			if (m.getnMemberID() == memberId) {
				return m;

			}

		}

		return null;

	}

}
