package com.project.lts.routing;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath extends DetermineRoute{
	
	public List<Vertex> findShortestPath(Vertex target)
	{
		List<Vertex> path = new LinkedList<Vertex>();
		for(Vertex v = target; v!= null; v = v.previousD)
		{
			path.add(v);
		}
		Collections.reverse(path);
		return path;
		
		
	}
	
	public void computePath(Vertex source)
	{
		source.minimumDistance = 0;
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(source);
		while(!q.isEmpty())
		{
			Vertex u = q.remove();
			for(Edge e: u.edge)
			{
				Vertex v = e.target;
				int minDistanceThruU = u.minimumDistance+e.distance;
				if(minDistanceThruU < v.minimumDistance)
				{
					v.minimumDistance = minDistanceThruU;
					v.previousD = u;
					q.add(v);
				}
			}
		}
	}
	
}
