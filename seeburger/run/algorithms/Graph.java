package com.seeburger.algorithms;

import java.util.LinkedList;

public class Graph {
	//represent a graph as array of linked lists, where the numberOfVertices is the size of listOfAdjacent
	private int numberOfVertices;
	private LinkedList<Integer>[] listOfAdjacent;
	
	public Graph(int v) {
		numberOfVertices = v;
		listOfAdjacent = new LinkedList[numberOfVertices];
		for (int i = 0; i < numberOfVertices; i++) {
			listOfAdjacent[i] = new LinkedList<>();
		}
	}
	
	//add and edge to undirected graph
	public static void addEdge(Graph graph, int v, int w) {
		graph.listOfAdjacent[v].addFirst(w);
		graph.listOfAdjacent[w].addFirst(v);
	}
	
	
	public static void printGraph(Graph gr) {
		
		for (int i = 0; i < gr.numberOfVertices; i++) {
			System.out.print("Adjacency list of vertex "+ i);
			for (Integer adj : gr.listOfAdjacent[i]) {
				System.out.print(" - " + adj);
			}
			System.out.println();
		}
		
	}
	
	public void depthFirstSearch(int v) {
		//mark all vertices as not visited 
		boolean visitedNode[] = new boolean[numberOfVertices];
		dfsUntil(v, visitedNode);
	}

	private void dfsUntil(int v, boolean[] visitedNode) {
		// mark current node as visited and print it
		visitedNode[v] = true;
		System.out.print(v + " ");
		
		//recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = listOfAdjacent[v].listIterator();
	    while (i.hasNext())
	    {
	        int n = i.next();
	        if (!visitedNode[n])
	            dfsUntil(n, visitedNode);
	    }
	}  
}
