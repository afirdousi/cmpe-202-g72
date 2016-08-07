
public class ScheduledRide implements ScheduledRideInterface {
	
	String  requestId;
	Vehicle vehicle;
	Member rider;
	Member driver;
	String rideState;

	State state;
	
	public ScheduledRide(){
		state= new WaitState(this);
	}
	
	public void receiveRequest(boolean x){
		System.out.println(state.receiveRequest(x));
	}
	
	public void calculateRide(boolean y){
		System.out.println(state.calculateRide(y));
	}
	public void dispatchRide(boolean z){
		System.out.println(state.dispatchRide(z));
	}
	
	public void setState(State s){
		state=s;
	}
	
	public State getState(){
		return state;
	}
	
	public void sendNotification(/*rider_id,driver_id,system,message*/){}
	
	public void completeRide(){}		//Notify System about ride completion

	
	
	

}
