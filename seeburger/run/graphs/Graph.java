package com.seeburger.algorithms.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.seeburger.exceptions.DestinationReachedException;

public class Graph {
	Town start;
	Town end;
	List<Road> route;
	
	public Graph(Town start, Town end, List<Road> roadList) {
		this.start = start;
		this.start.setCurrentDistance(0);
		this.end = end;
		this.route = roadList;
	}
	
	public void depthFirstSearch() throws DestinationReachedException {
		//mark all vertices as not visited 
//		boolean visitedNode[] = new boolean[route.size()];
		System.out.println("The depth first search traversal from " + this.start.getName() + " to " + this.end.getName() + " : ");
		dfsUntil(start, visitedNode);
	}

	private void dfsUntil(Town current, boolean[] visitedNode) throws DestinationReachedException{
		// mark current node as visited and print it
		visitedNode[current.getPosition(route)] = true;
		System.out.print(current.getName() + " ");
		
		//recur for all the vertices adjacent to this vertex
		Iterator<Town> i = current.getConnections().listIterator();
	    while (i.hasNext() ) 
	    {
	    	if(!current.equals(end)) {
	            Town n = i.next();

	            if (!visitedNode[n.getPosition(route)])  
	                dfsUntil(n, visitedNode); 
	    	}
	    	else {
	    		throw new DestinationReachedException("The destination has been reached from the DFS traversal.");
	    	}
	    }
	}
	
	public void breadthFirstSearch() {
		//mark all nodes as not visited
		boolean visitedNode[] = new boolean[route.size()];
		System.out.println("The breadth first search traversal from " + this.start.getName() + " to " + this.end.getName() + " : ");

		Queue<Town> queue = new LinkedList<>();
		//mark the current node as visited and add to the queue
		visitedNode[start.getPosition(route)] = true;
		queue.add(start);
		
		while(queue.size() != 0) {
			//poll a vertex from queue and print it
			start = queue.poll();
			System.out.print(start + " ");

			//get all the conections of the current source vertex
			Iterator<Town> i = start.getConnections().listIterator();
			if(start.equals(end))
				break;
			
			while(i.hasNext()) {
				
				Town n = i.next();
				//if connection is not visited - mark it visited and add it to queue
				if(!visitedNode[n.getPosition(route)]) {
					visitedNode[n.getPosition(route)] = true;
					queue.add(n);
				}
			}
		}    
	}
}