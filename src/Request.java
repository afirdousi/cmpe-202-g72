
public class Request {

	//TimeStamp  requestTime;
	int elapsedTime;//in seconds
	String requestType;
	String  startlocation;//Location objects
	String  endLocation;//Location object
	int seatsReuqested;
	Vehicle requestedVehicle ;//Attributes form vehicle class
	Member requestedBy;
	String requestState;//queing mechanism

	public void createRequest(/*requestTime,stratLocation,endLocation,seatsRequested,requestedVehicle,requestedBy*/){}
	
	public void retrieveRequest(String request_Id){}
	
	public void updateRequest(String request_id, String updatedinformation){}
	
	public void deleteRequest(String request_Id){}
	
	public void searchRequest(String request_Id){}
	
	public void selectRequest(String request_Id){}
	
	public void sortRequest(String requestTime, String requestType){}

	public void getListofUnassignedRequest(String requestStatus, String requestId){}  // to know all pending requests
	
	public void getListofUnassignedVehicle(String vehicleStatus, String vehicleId){}// to know which vehicles are available for ride 
	
	public void processRequest(){}		// to match the pending request with available vehicle
	
	public void sendNotification(){}
	
	public void assignVehicleforFutureRide(){} // example : assigning a vehicle for a ride next week 
	
	public void dispatchVehicle(){} // prompt driver about ride ( immediate or scheduled for next week ) 

}
