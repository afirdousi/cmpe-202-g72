package com.project.lts.routing;

import java.util.List;

public abstract class DetermineRoute {
	
	public int determineTime(Vertex target) {
		return target.minimumTime;
	}

	public int determineDistance(Vertex target){
		return target.minimumDistance;
	}
	
	public abstract void computePath(Vertex source);
	public abstract List<Vertex> findShortestPath(Vertex target);

	
	
	
}
