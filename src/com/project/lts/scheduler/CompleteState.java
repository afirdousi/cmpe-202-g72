package com.project.lts.scheduler;
import java.util.*;

import com.project.lts.accounts.Member;
import com.project.lts.notification.Notification;
import com.project.lts.payment.PaymentManager;
import com.project.lts.routing.*;
import com.project.lts.routing.Vertex;

public class CompleteState implements State{

	private ScheduledRideInterface scheduledRide;
	//PaymentManager paymentManager ;
	Scanner inputManager;
	Notification notificationManager = new Notification();
	
	
	public CompleteState(ScheduledRideInterface s){
		scheduledRide=s;
		
	}

	public void receiveRequest(String source, String destination){
		//System.out.println("Request received for route : " + source + " to " + destination);
	}
	
	public List<List<Vertex>> calculateRide(String source, String destination){
		return null;
	}
	public void dispatchRide(List<List<Vertex>> suggestedRoutes,int algoType){
		//return null;
	}
	
	public void completeRide(int rideAmount ,Ride completedRide){
		
		String rating,feedback,wantToGiveFeedback;
		
		inputManager = new Scanner(System.in);
		System.out.println("Ride ID:" + completedRide.getID()  + " completed. Payment has been processed. Do you want to give feedback? [1]Yes  [2]No");
		wantToGiveFeedback = inputManager.nextLine();
		
		if(wantToGiveFeedback.equalsIgnoreCase("1")){
			
			for(Member m:completedRide.getMembers()){
				
				inputManager = new Scanner(System.in);
				System.out.println("Congratulations " + m.getMemFname() + " on completing the Ride ID: " + completedRide.getID());
				System.out.println("Enter rating (out of 5)");
				rating = inputManager.nextLine();
				System.out.println("How was your ride? Enter feedback:");
				feedback = inputManager.nextLine();
				
				//Update ride with user feedback and rate
				completedRide.riderRating = rating;
				completedRide.riderFeedback = feedback;
				
				//Send notification to driver
				notificationManager.sendToOne(" Feedback received from rider for driver ", completedRide.vehicle.getvDriver() );
				notificationManager.sendToOne(" Rating : " + rating + " out of 5 for driver ", completedRide.vehicle.getvDriver() );
				
			}
		}
		
			
		
	}
	
}
