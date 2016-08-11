package com.project.lts.scheduler;

import java.util.List;

import com.project.lts.routing.*;

public interface State {

	public void receiveRequest(int source, int destination);
	
	public List<List<Vertex>> calculateRide(int source, int destination);
	
	public void dispatchRide(List<List<Vertex>> suggestedRoutes);
}
