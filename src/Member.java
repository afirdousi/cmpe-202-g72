import java.util.ArrayList;
import java.util.List;

public class Member {
	String  name;
	String  email;
	String  phoneNumber;
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
				member.name = m.name;
				member.email = m.email;
				member.phoneNumber = m.phoneNumber;
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
		this.name = name;
		
	}
	
	public String getMemberName(){
		return this.name;
	}
	
	public void setMemberEmail(String email){
		this.email = email;
	}
	
}
