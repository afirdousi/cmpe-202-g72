package com.project.lts.routing;

import java.util.List;

public class Route2 implements GenerateRoute{
	
	DetermineRoute determineRoute;
	
	public Vertex[] generateRoute()
	{
		Vertex vertex0 = new Vertex(0);
		Vertex vertex1 = new Vertex(1);
		Vertex vertex2 = new Vertex(2);
		Vertex vertex3 = new Vertex(3);
		Vertex vertex4 = new Vertex(4);
		
		
		vertex0.edge.add(new Edge(vertex1, 1,1));
		vertex0.edge.add(new Edge(vertex3, 3,3));
		vertex0.edge.add(new Edge(vertex4, 4,2));
		
		vertex1.edge.add(new Edge(vertex3, 1,1));
		
		vertex2.edge.add(new Edge(vertex0, 1,1));
		
		vertex3.edge.add(new Edge(vertex4, 1,1));
		
		vertex4.edge.add(new Edge(vertex2, 1,1));
		
		Vertex[] vertices = {vertex0, vertex1, vertex2, vertex3, vertex4};
		
		return vertices;
	}
	
	
	public List<Vertex> findLeastTime(int i, int j) {
		
		Vertex[] vertix = generateRoute();
		
		determineRoute = new LeastTime();
		determineRoute.computePath(vertix[i]);
		
		Vertex targetVertex = vertix[j];
		
		//System.out.println("Min Time to Destination "+targetVertex+" : "+determineRoute.determineTime(targetVertex));
		List<Vertex> pathT = determineRoute.findShortestPath(targetVertex);
		//System.out.println("Path : "+pathT);
		
		return pathT;
	}

	
	public DetermineRoute determineRoute() {
		// TODO Auto-generated method stub
		return new LeastTime();
	}

}
