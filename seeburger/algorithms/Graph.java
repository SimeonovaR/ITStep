package com.seeburger.algorithms;

import java.util.LinkedList;

public class Graph {
	private int numberOfVertices;
	private LinkedList<Integer>[] listOfAdjacent;
	
	public Graph(int v) {
		numberOfVertices = v;
		listOfAdjacent = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			listOfAdjacent[i] = new LinkedList<>();
		}
	}
	
	public void printGraph(int v) {
		numberOfVertices = v;
		listOfAdjacent = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			System.out.println(listOfAdjacent[i]);
		}
	}
	
	public void addNewVertices(int v, int w) {
		listOfAdjacent[v].add(w);
	}
	
	int getNumberOfVertices() {
		return numberOfVertices;
	}
	
	LinkedList<Integer>[] getAdjacent(int nodeIndex) {
		
		listOfAdjacent = new LinkedList[nodeIndex];
		for (int i = 0; i < nodeIndex; i++) {
			listOfAdjacent[i] = new LinkedList<>();
		}
		return listOfAdjacent;
	}

	public int getPeekOfGraph() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
