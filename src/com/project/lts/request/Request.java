package com.project.lts.request;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Request {
	
	Timestamp requestArrivalTime;
	Timestamp requestDispatchTime;
	Timestamp requestElapsedTime;
	
	CurrentRideRequest crr;
	FutureRideRequest frr;
	
	public Request(){
		
	}
	
	
	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}

	
}

