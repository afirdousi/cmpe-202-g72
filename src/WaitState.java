
public class WaitState implements State{
	
	private ScheduledRideInterface sc;
	
	public WaitState(ScheduledRideInterface s){
		sc=s;
	}

	public String receiveRequest(boolean x){
		if (x==true){
		sc.setState(new CalculateState(sc));
		return "Received Request";
		}
		else
			return"Request not received";
	}
	
	public String calculateRide(boolean y){
		return "Request must be received";
	}
	public String dispatchRide(boolean z){
		return "Request must be received";
	}
}
