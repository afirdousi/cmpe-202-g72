package com.project.lts.notification;
import com.project.lts.member.Member;

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
			System.out.println("EMAIL Received : "  + this.message.text +  " : Receiver = " + m.getMemberName()  + "(" + m.getEmail() +  ")" );
			System.out.println("Text Message Received : " + this.message.text +  " : Receiver = " + m.getMemberName()  + "(" + m.getPhoneNumber() +  ")" );
		}
		
	}
	
	//For sending immediate message to all current observers without saving/setting/archieving the message
	public void sendImmidiate(String message){
		for(Member m : this.obs.observers){
			System.out.println("EMAIL Received : " + message +  " : Receiver =" + m.getMemberName()  + "(" + m.getEmail() +  ")" );
			System.out.println("Text Message Received : " + message +  " : Receiver =" + m.getMemberName()  + "(" + m.getPhoneNumber() +  ")" );
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
