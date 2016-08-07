
public class ScheduleTest {

	static ScheduledRide sr;
	public static void main(String[] args){
		sr= new ScheduledRide();
		sr.receiveRequest(false);
		sr.calculateRide(true);
		sr.dispatchRide(false);
	}
}
