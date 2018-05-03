package com.seeburger.run;

import com.seeburger.algorithms.DFS;
import com.seeburger.algorithms.Graph;

public class RunApp {
	
	public static void main(String[] args) {
	int numOfVertices = 5;
        Graph graph = new Graph(numOfVertices);
        Graph.addEdge(graph, 0, 1);
        Graph.addEdge(graph, 0, 4);
        Graph.addEdge(graph, 1, 2);
        Graph.addEdge(graph, 1, 3);
        Graph.addEdge(graph, 1, 4);
        Graph.addEdge(graph, 2, 3);
        Graph.addEdge(graph, 3, 4);
      
        Graph.printGraph(graph);
        
	int initialVertex;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a valid initial vertex of the graph: ");
            initialVertex = sc.nextInt();
        } while(initialVertex > numOfVertices || initialVertex < 0);

        graph.depthFirstSearch(initialVertex);
        System.out.println();
        graph.breadthFirstSearch(initialVertex);
	}
	
}
