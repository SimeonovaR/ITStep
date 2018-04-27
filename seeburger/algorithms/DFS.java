package com.seeburger.algorithms;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {
	public void DepthFirstSearch(Graph graph) {
		boolean visitedNode[] = new boolean[graph.getNumberOfVertices()];
		
		Stack st = new Stack();
		int peek = graph.getPeekOfGraph();
		
		for (int i = 0; i < graph.getNumberOfVertices(); i++) {
			st.push(peek);
			System.out.print(peek + " ");
			visitedNode[i] = true;
			LinkedList<Integer>[] adjacents = graph.getAdjacent(i);
		
		}

	}
}
