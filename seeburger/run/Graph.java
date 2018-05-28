package com.seeburger.algorithms.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph {
	Town start;
	Town end;
	List<Town> route;
	
	public Graph(Town start, Town end, List<Town> townList) {
		this.start = start;
		this.end = end;
		this.route = new ArrayList<Town>(townList.subList(start.getPosition(townList), end.getPosition(townList)));
	}
	
	public void depthFirstSearch() {
		//mark all vertices as not visited 
		boolean visitedNode[] = new boolean[this.route.size()];
		System.out.println("The depth first search traversal from " + this.start.getName() + " to " + this.end.getName() + " : ");
		dfsUntil(start, visitedNode);
	}

	private void dfsUntil(Town current, boolean[] visitedNode) {
		// mark current node as visited and print it
		visitedNode[current.getPosition(route)] = true;
		System.out.print(current.getName() + " ");
		
		//recur for all the vertices adjacent to this vertex
		Iterator<Town> i = current.getConnections().listIterator();
	    while (i.hasNext())
	    {
	        Town n = i.next();
	        if (!visitedNode[n.getPosition(route)])
	            dfsUntil(n, visitedNode);
	    }
	}
}
