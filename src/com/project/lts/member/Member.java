package com.project.lts.member;
import java.util.ArrayList;
import java.util.List;

public class Member {
	private String  name;
	private String  email;
	private String  phoneNumber;
	String  address;
	String  password;
	String  dob;
	String  licenceNumber;
	String 	paymentDetails;
	String 	ID;
	boolean isPremiumMember;
	
	List<Member> members = new ArrayList<Member>();

	public void createMember(Member m){
		this.members.add(m);
	}
	
	//Check for ID null when you retrieve member
	public Member searchMember(){
		
		Member result = new Member();
		
		for(Member member : members){
			if(member.ID==ID){
				result = member;
				break;
			}
		}
		
		return result;
	}
	
	public void updateMember(Member m){
		for(Member member : members){
			if(m.ID==ID){
				member.setName(m.getName());
				member.setEmail(m.getEmail());
				member.setPhoneNumber(m.getPhoneNumber());
				member.address = m.address;
				member.password = m.password;
				member.dob = m.dob;
				member.licenceNumber = m.licenceNumber;
				member.paymentDetails = m.paymentDetails;
				member.isPremiumMember = m.isPremiumMember;
				
				break;
			}
		}
		
	}
	
	public void deleteMember(String ID){
		for(Member m : members){
			if(m.ID==ID){
				this.members.remove(m);
				
				break;
			}
		}

	}
	
	
	public void sortMember(){}	//ascending order
	//Will add all getter and setter for this class  
	
	public void setMemberName(String name){
		this.setName(name);
		
	}
	
	public String getMemberName(){
		return this.getName();
	}
	
	public void setMemberEmail(String email){
		this.setEmail(email);
	}
	
	public List<Member> setupMockMember() {
		
		List<Member> members = new ArrayList<Member>();
		
		return members;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
