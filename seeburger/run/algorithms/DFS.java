package com.seeburger.algorithms;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	public static void depthFirstSearch(Graph graph, int v) {
		//mark all vertices as not visited 
		boolean visitedNode[] = new boolean[v];
		Integer adjVertex = graph.getAdjVertex(v);
		dfsUntil(v, visitedNode, adjVertex);
	}

	private static void dfsUntil(int v, boolean[] visitedNode, Integer adjVertex) {
		// mark current node as visited and print it
		visitedNode[v] = true;
		System.out.print(v + " ");
		
		//recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adjVertex.listIterator();
	    while (i.hasNext())
	    {
	        int n = i.next();
	        if (!visitedNode[n])
	            dfsUntil(n, visitedNode, adjVertex);
	    }
	} 
}
