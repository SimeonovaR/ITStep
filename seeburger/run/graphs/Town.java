package com.seeburger.algorithms.graphs;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Town {
	// Any data members can be defined
	private String name;

	private double currentDistance;

	// Connectivity to other nodes
	private List<Road> connections;

	public Town() {
		this.connections = new ArrayList<Road>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addConnection(Road road) {
		if (!this.connections.contains(road)) {
		    this.connections.add(road);
			road.getTown2().connections.add(road);
		}
	}

	public void removeConnection(Road road) {
		if (this.connections.contains(road)) {
			this.connections.remove(road);
			road.getTown2().connections.remove(road);
		}
	}

	public List<Road> getConnections() {

		ArrayList<Road> list = new ArrayList<>();
		Iterator<Road> i = connections.listIterator();
		while (i.hasNext()) {
			Road n = i.next();
			if (!list.contains(n)) { 
				list.add(n);
			}
		}
		return list;
	}

	@Override
	public boolean equals(Object other) {
		   if (other instanceof Town) {
	            if (name.equals(((Town) other).name)) {
	                return true;
	            }
	        }
	        return false;
	}

	@Override
	public String toString() {
		return name + " ";
	}

	public double getCurrentDistance() {
		return currentDistance;
	}

	public void setCurrentDistance(double currentDistance) {
		this.currentDistance = currentDistance;
	}
}
