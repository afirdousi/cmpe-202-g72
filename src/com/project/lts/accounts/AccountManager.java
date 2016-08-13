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


public class AccountManager {

	Customer cs;


	public ArrayList<Member> mArr;

	public AccountManager() {

		this.mArr = new ArrayList<Member>();
/*
		Member m1 = new Customer("Cust002", "Ronak", "Cust2Lname", "Cust02@yahoo.com", "4085550002", "Cust2 Address1",
				"Cust2 Address2", "Cust2 City", "Cust2 State", "90002", "Email", "Cash", "1234567890120002", "Y",
				"PREMIER", "C","null","null","null");
		mArr.add(m1);

		Member m2 = new Customer("Cust003", "Shyam", "Cust2Lname", "Cust02@yahoo.com", "4085550002", "Cust2 Address1",
				"Cust2 Address2", "Cust2 City", "Cust2 State", "90002", "Email", "Cash", "1234567890120002", "Y",
				"PREMIER", "C","null","null","null");
		mArr.add(m2);
*/
	}



	public void addMembers(Member m, List<Member> members1)
	// This method add members to Member array members1
	{

		if (!members1.isEmpty()) {


			members1.add(m);
			System.out.println("After adding the size of the members arraylist = " + members1.size());

			// sortMembers(members);
			for (int i = 0; i < members1.size(); i++)

			{

				System.out.println("\n" + members1.get(i).getnMemberID() + " " + members1.get(i).getMemFname() + " * "
						+ members1.get(i).getMemLname() + " * " + members1.get(i).getMemEmail() + " * "
						+ members1.get(i).getMemPhone() + " * " + members1.get(i).getMemRole() + " Member type= "
						+ members1.get(i).getMemType());
				// System.out.println(members1.get(i).getMemLname());

			}
		} // if

	} // method end



	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

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

	public Member retrieveCustomer(String memberId)

	{
		boolean retflag = false;
		System.out.println("Printing after retrieving ..");

		for (int i = 0; i < AccountClient.members1.size() && !retflag; i++) {

			if (AccountClient.members1.get(i).getnMemberID().equalsIgnoreCase(memberId)) {

				System.out.println("\n" + AccountClient.members1.get(i).getnMemberID() + " "
						+ AccountClient.members1.get(i).getMemFname() + " * "
						+ AccountClient.members1.get(i).getMemLname() + " * "
						+ AccountClient.members1.get(i).getMemEmail() + " * "
						+ AccountClient.members1.get(i).getMemPhone() + " * "
						+ AccountClient.members1.get(i).getMemCreditcard() + " * "
						+ AccountClient.members1.get(i).getMemPaypalId() + " * "
						+ AccountClient.members1.get(i).getMemRole());

				return AccountClient.members1.get(i);


			}



		}

		return null;

	}


	public static void SearchCustomer(String CustId) {
		// TODO implement me
		// This method is used to retrieve a member from the array
		{

			System.out.println("Printing after Searching..");
			boolean foundflag = false;
			System.out.println("Array size = " + AccountClient.members1.size());
			for (int i = 0; i < AccountClient.members1.size() && !foundflag; i++) {

				if (AccountClient.members1.get(i).getnMemberID().equalsIgnoreCase(CustId)) {
					System.out.println("Member found\n" + CustId);
					foundflag = true;
					System.out.println("Member details Searched " + AccountClient.members1.get(i).memFname + " "
							+ AccountClient.members1.get(i).getMemEmail());
					// AccountClient.members1.get(i).memFname= CustFName;
				}

			}
			if (!foundflag) {
				System.out.println("Member is not found..Pl enter correct member ID");
				foundflag = true;
			}

		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static void updateCustomer(String CustFName, String CEmail) {
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

	public static void sortCustomers()

	{
		boolean retflag = false;

		Collections.sort(AccountClient.members1, new SortComparator());

		System.out.println("Sorted list ");
		for (Member e : AccountClient.members1) {
			System.out.println("Member ID " + e.getnMemberID());
			System.out.println("Member First Name " + e.getMemFname());
			System.out.println("Member Email " + e.getMemEmail());

		}



	}

	public static void selectCustomer(String CustFName)

	{
		boolean selectflag = false;
		System.out.println("Printing after selecting ..");

		for (int i = 0; i < AccountClient.members1.size() && !selectflag; i++) {

			if (AccountClient.members1.get(i).getMemFname().equalsIgnoreCase(CustFName)) {
				selectflag = true;
				System.out.println("Selected Member * " + CustFName + " * Email address is *  "
						+ AccountClient.members1.get(i).memEmail);
				// AccountClient.members1.get(i).memFname= CustFName;
			}

		}
		if (selectflag)
			System.out.println("Member has been selected successfully!");
		else
			System.out.println("Member not found to select.. Pl enter correct membername");

	}

	public Member retrieveMember(String memberId)

	{

		
		for (Member m : this.mArr) {

			if (m.getnMemberID() == memberId) {


				
				return m;

			}
		
		}
		
		return null;

	}

}
