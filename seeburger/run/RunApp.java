package com.seeburger.run;

import com.seeburger.algorithms.Graph;

public class RunApp {
	
	public static void main(String[] args) {
		Graph gr = new Graph(6);
		gr.addNewVertices(0, 1);
		gr.addNewVertices(0, 2);
		gr.addNewVertices(1, 3);
		gr.addNewVertices(1, 4);
		gr.addNewVertices(2, 4);
		gr.addNewVertices(3, 4);
		gr.addNewVertices(3, 5);
		gr.addNewVertices(4, 5);
		
		gr.printGraph(6);
	}
	
}
