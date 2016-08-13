package com.project.lts.scheduler;

import java.util.List;

import com.project.lts.routing.*;

public interface State {

	public void receiveRequest(String source, String destination);
	
	public List<List<Vertex>> calculateRide(String source, String destination);
	
	public void dispatchRide(List<List<Vertex>> suggestedRoutes,int algoType);
}
