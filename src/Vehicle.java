import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	
	String  make;
	String  type;
	String  model;
	String  year;
	String  vehicleIdentificationNumber;
	String  color;
	int seats;
	boolean hasWheelchair;
	boolean hasInfantchair;
	boolean hasAC;
	Vehicle vehicleOwner;
	/*Need to discuss
	String  licenceNumber*/
	
	List<Vehicle> vehicles = new ArrayList<Vehicle>();

	public void createVehicle(Vehicle v){
		this.vehicles.add(v);
	}
	
	public Vehicle searchVehicle(String vehicleIdentificationNumber){
		
		 Vehicle result = new Vehicle();
		
		for(Vehicle vehicle : vehicles){
			if(vehicle.vehicleIdentificationNumber== vehicleIdentificationNumber){
				result = vehicle;
				break;
			}
		}
		
		return result;
	}
	
	public void updateVehicle(Vehicle v){
		for(Vehicle vehicle : vehicles){
			if(v.vehicleIdentificationNumber == vehicle.vehicleIdentificationNumber){
				vehicle.make = v.make;
				vehicle.type = v.type;
				vehicle.model = v.model ;
				vehicle.year = v.year;
				
				vehicle.color = v.color;
				vehicle.seats = v.seats;
				vehicle.hasWheelchair = v.hasWheelchair;
				vehicle.hasInfantchair  = v.hasInfantchair;
				vehicle.hasAC = v.hasAC;
				vehicle.vehicleOwner  = v.vehicleOwner;
				
				break;
			}
		}
		
	}
	
	public void deleteVehicle(String vehicleIdentificationNumber){
		for(Vehicle v : vehicles){
			if(v.vehicleIdentificationNumber==vehicleIdentificationNumber){
				this.vehicles.remove(v);
				
				break;
			}
		}

	}
	
	public void selectVehicle(String Id){}
	
	public void sortVehicle(){}	//ascending order
	//Will add all getter and setter for this Vehicle class  
	
	public void setVehicleModel(String model){}
	
	public void getVehicleModel(){}
	
	public void setVehicleColor(String color){}
	
	public void getVehicleColor(){}
	
	public List<Vehicle> setupMockVehicles() {
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		return vehicles;
		
	}
	

}
