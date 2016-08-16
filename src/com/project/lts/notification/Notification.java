package com.project.lts.notification;
import java.util.ArrayList;
import java.util.List;

import com.project.lts.accounts.Member;

public class Notification {
	
	Message message = new Message("",-1);
	Observable obs = new Observable();
	
	public void setMessage(String message){
		this.message.setMessage(message);
	}
	
	public void updateMessage(String message){
		this.message.setMessage(message);
		this.send();
	}
	
	public void setListener(Member m){
		this.obs.add(m);
	}
	
	public void setListener(List<Member> members){
		this.obs.add(members);
	}	
	
	public void removeListener(Member m){
		this.obs.remove(m);
	}
	
	public void resetListeners(){
		this.obs.removeAll();
	}
	
	public void reset(){
		this.message = new Message("",-1);
		this.obs = new Observable();
	}
	
	
	public void send(){
		for(Member m : this.obs.observers){
			System.out.println("NOTIFICATION  : EMAIL Received : "  + this.message.text +  " : Receiver = " + m.getMemFname() + "(" + m.getMemEmail() +  ")" );
			System.out.println("NOTIFICATION  : Text Message Received : " + this.message.text +  " : Receiver = " + m.getMemFname()  + "(" + m.getMemPhone() +  ")" );
		}
		
	}
	
	//For sending immediate message to all current observers without saving/setting/archieving the message
	public void sendImmidiate(String message){
		for(Member m : this.obs.observers){
			System.out.println("NOTIFICATION  : EMAIL Received : " + message +  " : Receiver =" + m.getMemFname()  + "(" + m.getMemEmail() +  ")" );
			System.out.println("NOTIFICATION  : Text Message Received : " + message +  " : Receiver =" + m.getMemFname()  + "(" + m.getMemPhone() +  ")" );
		}
		
	}
	
	//TODO: 
	//Add send() types for sending email only OR text message only notifications
	
	
	
//	public void retriveMemberDetail(){}
//	
//	public void updateNotification(String message, String id){}
//	
//	public void deleteNotification(String message){}
//	
//	public void sendNotification(String message){
//		
//		System.out.println("NOTIFICATION : " + message);
//		
//	}
//	
//	public void receiveNotification(String message){}
//		
//	//Will add all getter and setter for this class  
//	public void setNotification(String message,String memberId){}
//	
//	public void getNotification(){}


}
