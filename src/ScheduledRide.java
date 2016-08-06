
public class ScheduledRide {
	
	String  requestId;
	Vehicle vehicle;
	Member rider;
	Member driver;
	String rideState;

	public void updateRideState(){}//notpickedup,pickup,start,inprocess,drop
	
	public void startRide(/*requestId,vehicle,rider,driver*/){}
	
	public void sendNotification(/*rider_id,driver_id,system,message*/){}
	
	public void completeRide(){}		//Notify System about ride completion

}
