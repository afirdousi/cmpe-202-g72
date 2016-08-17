/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/


package com.project.lts.accounts;

import java.util.List;



/**
 * Author:  Thiagarajan Natarajan
 * Purpose: Member class with getters and setters
 * Date: 08/04/2015
 */

public class Customer extends Member
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	
	public Customer(){
		
	}
	
	
	public Customer( String memId , String strmFName, String strmLName, String strmEmail, String strmPhone,
			String strmAddress1, String strmAddress2, String strmCity, String strmState, String strmZipcode,String strmPrefnotfn
	,String strmPrefpmt, String strmCreditcard, String strmPrimeflag , String strmRole, String strmmemType, String strmCreditexpdate,String strmCreditCVV,String strmPaypalId)
	
	
	{
	
		
	//	super();
		
		
		 this.memFname =strmFName;
		   this.memLname = strmLName;
		   this.memEmail = strmEmail;
		   this.memPhone = strmPhone;
		   this.memAddress1 = strmAddress1;
		   this.memAddress2 = strmAddress2;
		   this.memCity= strmCity;
		   this.memState = strmState;
		   this.memZipcode = strmZipcode;
		   this.memPrefnotfn = strmPrefnotfn;
		   this.memPrefpmt = strmPrefpmt;
		   this.memCreditcard = strmCreditcard;
		   this.memPrimeflag = strmPrimeflag;
		   this.nMemberID = memId;
		   this.memRole =strmRole;
		   this.memType=strmmemType;
		   this.memCreditexpdate = strmCreditexpdate;
		   this.memCreditCVV = strmCreditCVV;
		   this.memPaypalId = strmPaypalId;
	    
	}
	

}

