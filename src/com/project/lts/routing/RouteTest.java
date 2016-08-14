package com.project.lts.routing;

public class Route {
	
	public static void main(String[] args)
	{
		// Take source and destination
		int source = 0;
		int dest = 4;
		
		
		Route1 r1 = new Route1();		
		r1.findShortestDistance(source, dest);
		
		
		Route2 r2= new Route2();		
		r2.findLeastTime(source, dest);
		
		
		
		
	}
	

}
