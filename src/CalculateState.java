
public class CalculateState implements State{

	private ScheduledRideInterface sc;
	
	public CalculateState(ScheduledRideInterface s){
		sc=s;
	}

	public String receiveRequest(boolean x){
		return "Received Request";
	}
	
	public String calculateRide(boolean x){
		sc.setState(new DispatchState(sc));
		return "Route Calculated, Ready for dispatch!";
	}
	public String dispatchRide(boolean x){
		return "Request is being processed";
	}
}
