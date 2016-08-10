package com.project.lts.scheduler;
public interface State {

	public String receiveRequest(boolean x);
	
	public String calculateRide(boolean y);
	
	public String dispatchRide(boolean z);
}
