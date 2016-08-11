package com.project.lts.routing;

import java.util.LinkedList;
import java.util.List;

public class Vertex
{
	int name;
	
	int minimumDistance;
	Vertex previousD;
	int minimumTime;
	List<Edge> edge;
	Vertex previousT;
	
	Vertex(int name)
	{
		
		this.name = name;
		this.minimumDistance = Integer.MAX_VALUE;
		this.minimumTime = Integer.MAX_VALUE;
		this.edge = new LinkedList<Edge>();
		
	}
	
	public String toString()
	{
		return Integer.toString(name);
	}
}
