package com.project.lts.routing;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeastTime extends DetermineRoute{

	@Override
	public List<Vertex> findShortestPath(Vertex target) {
		List<Vertex> path = new LinkedList<Vertex>();
		for(Vertex v = target; v!= null; v = v.previousT)
		{
			path.add(v);
		}
		Collections.reverse(path);
		return path;
		
		
	}
	
	

	public void computePath(Vertex source)
	{
		source.minimumTime = 0;
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(source);
		while(!q.isEmpty())
		{
			Vertex u = q.remove();
			for(Edge e: u.edge)
			{
				Vertex v = e.target;
				int minTimeThruU = u.minimumTime+e.time;
				if(minTimeThruU < v.minimumTime)
				{
					v.minimumTime = minTimeThruU;
					v.previousT = u;
					q.add(v);
				}
			}
		}
	}

}
