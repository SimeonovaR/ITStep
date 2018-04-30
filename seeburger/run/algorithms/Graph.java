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

	public int getNumberOfVertices() {
		return numberOfVertices;
	}
	
	public Integer getAdjVertex(int v) {
		return listOfAdjacent[v].get(v);
	}
}
