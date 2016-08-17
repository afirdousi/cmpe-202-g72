/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.accounts;
import java.util.*;

import com.project.lts.notification.Notification;


public abstract class Member
{
	String nMemberID; 
	String memFname;
	String memLname;
	String memEmail;
	String memPhone;  
	String memAddress1;
	String memAddress2;
	String memCity;
	String memState;
	String memZipcode;
	String memPrefnotfn;
	String memPrefpmt;
	String memCreditcard;
	String memCreditexpdate;
	String memCreditCVV;
	String memPaypalId;
	String memPrimeflag;
	String memType; //C: Regular Rider //D:Driver
	
	ArrayList<String> coupons = new ArrayList<String>();
	Notification notificationManager = new Notification();
	
	//get all current coupons for this member
	ArrayList<String> getCoupons(){
		return this.coupons;
	}
	
	//This will be called in 2 condtions
	//Either one member send coupon to another member
	public void receiveCoupon(String coupon,Member sharingMember){
		
		notificationManager.reset();
		notificationManager.setListener(this);
		notificationManager.setListener(sharingMember);
		
		this.coupons.add(coupon);
		
		notificationManager.setMessage("Coupon shared by Member:" + sharingMember.getMemFname() + " received by Member:" + this.getnMemberID());
	    notificationManager.send();
		
	}
	
	//If you schedule more than 2 rides
	public void addCoupon(String coupon){
		
		notificationManager.reset();
		notificationManager.setListener(this);
		
		this.coupons.add(coupon);
		
		notificationManager.setMessage("NOTIFICATION : Coupon added to account for Member:" + this.getnMemberID());
	    notificationManager.send();
		
	}
	
	//Called when coupon is shared with someone else
	//Called when ride is cancelled and ride count for member goes below 2
	public void removeCoupon(){
		this.coupons.remove(0);
	}
	
	public String getMemCreditexpdate() {
		return memCreditexpdate;
	}



	public void setMemCreditexpdate(String memCreditexpdate) {
		this.memCreditexpdate = memCreditexpdate;
	}



	public String getMemCreditCVV() {
		return memCreditCVV;
	}



	public void setMemCreditCVV(String memCreditCVV) {
		this.memCreditCVV = memCreditCVV;
	}



	public String getMemPaypalId() {
		return memPaypalId;
	}



	public void setMemPaypalId(String memPaypalId) {
		this.memPaypalId = memPaypalId;
	}



	
	
	//Account account;
	

    String memRole;  
	
	public String getMemRole() {
		return memRole;
	}



	public void setMemRole(String memRole) {
		this.memRole = memRole;
	}



	 public Member()
	{
		
	   
	}

	
	
	/**
	 * @return the nMemberID
	 */
	public final String getnMemberID() {
		return nMemberID;
	}



	/**
	 * @param nMemberID the nMemberID to set
	 */
	public final void setnMemberID(String nMemberID) {
		this.nMemberID = nMemberID;
	}

	/**
	 * @return the memFname
	 */
	public final String getMemFname() {
		return memFname;
	}



	/**
	 * @param memFname the memFname to set
	 */
	public final void setMemFname(String memFname) {
		this.memFname = memFname;
	}



	/**
	 * @return the memLname
	 */
	public final String getMemLname() {
		return memLname;
	}



	/**
	 * @param memLname the memLname to set
	 */
	public final void setMemLname(String memLname) {
		this.memLname = memLname;
	}



	/**
	 * @return the memEmail
	 */
	public final String getMemEmail() {
		return memEmail;
	}



	/**
	 * @param memEmail the memEmail to set
	 */
	public final void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	/**
	 * @return the memPhone
	 */
	public final String getMemPhone() {
		return memPhone;
	}



	/**
	 * @param memPhone the memPhone to set
	 */
	public final void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	/**
	 * @return the memAddress1
	 */
	public final String getMemAddress1() {
		return memAddress1;
	}



	/**
	 * @param memAddress1 the memAddress1 to set
	 */
	public final void setMemAddress1(String memAddress1) {
		this.memAddress1 = memAddress1;
	}



	/**
	 * @return the memAddress2
	 */
	public final String getMemAddress2() {
		return memAddress2;
	}



	/**
	 * @param memAddress2 the memAddress2 to set
	 */
	public final void setMemAddress2(String memAddress2) {
		this.memAddress2 = memAddress2;
	}



	/**
	 * @return the memCity
	 */
	public final String getMemCity() {
		return memCity;
	}



	/**
	 * @param memCity the memCity to set
	 */
	public final void setMemCity(String memCity) {
		this.memCity = memCity;
	}



	/**
	 * @return the memState
	 */
	public final String getMemState() {
		return memState;
	}



	/**
	 * @param memState the memState to set
	 */
	public final void setMemState(String memState) {
		this.memState = memState;
	}



	/**
	 * @return the memZipcode
	 */
	public final String getMemZipcode() {
		return memZipcode;
	}



	/**
	 * @param memZipcode the memZipcode to set
	 */
	public final void setMemZipcode(String memZipcode) {
		this.memZipcode = memZipcode;
	}



	/**
	 * @return the memPrefnotfn
	 */
	public final String getMemPrefnotfn() {
		return memPrefnotfn;
	}



	/**
	 * @param memPrefnotfn the memPrefnotfn to set
	 */
	public final void setMemPrefnotfn(String memPrefnotfn) {
		this.memPrefnotfn = memPrefnotfn;
	}



	/**
	 * @return the memPrefpmt
	 */
	public final String getMemPrefpmt() {
		return memPrefpmt;
	}



	/**
	 * @param memPrefpmt the memPrefpmt to set
	 */
	public final void setMemPrefpmt(String memPrefpmt) {
		this.memPrefpmt = memPrefpmt;
	}



	/**
	 * @return the memCreditcard
	 */
	public final String getMemCreditcard() {
		return memCreditcard;
	}



	/**
	 * @param memCreditcard the memCreditcard to set
	 */
	public final void setMemCreditcard(String memCreditcard) {
		this.memCreditcard = memCreditcard;
	}



	/**
	 * @return the memPrimeflag
	 */
	public final String getMemPrimeflag() {
		return memPrimeflag;
	}



	/**
	 * @param memPrimeflag the memPrimeflag to set
	 */
	public final void setMemPrimeflag(String memPrimeflag) {
		this.memPrimeflag = memPrimeflag;
	}
	public final String getMemType() {
		return memType;
	}



	public void setMemType(String memType) {
		this.memType = memType;
	}

}

