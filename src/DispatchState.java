
public class DispatchState implements State{

	private ScheduledRideInterface sc;
	
	public DispatchState(ScheduledRideInterface s){
		sc=s;
	}

	public String receiveRequest(boolean x){
		return "Received Request";
	}
	
	public String calculateRide(boolean y){
		return "Request is processed";
	}
	public String dispatchRide(boolean z){
		sc.setState(new WaitState(sc));
		return "Ride Dispatched!!";
	}
}
