package com.project.lts.routing;

class Edge
{
	int distance;
	Vertex target;
	int time;
	
	Edge(Vertex target, int weight, int time)
	{
		this.target = target;
		this.distance = weight; //distance (in miles) 
		this.time = time;
	}
}
