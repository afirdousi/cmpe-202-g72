
public interface ScheduledRideInterface {

	public State getState();
	
	public void setState(State s);

	public void receiveRequest(boolean x);
	
	public void calculateRide(boolean y);
	
	public void dispatchRide(boolean z);
	
}

