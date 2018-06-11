package com.seeburger.algorithms.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Town
{
	// Any data members can be defined
	private String name;

	private double currentDistance;

	// Connectivity to other nodes
	private List<Road> connections;

	public Town()
	{
		this.connections = new ArrayList<Road>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addConnection(Road n2)
	{
		if (!this.connections.contains(n2))
		{
			this.connections.add(n2);
			n2.addConnection(this);
		}
	}

	// TODO: removeConnection, other methods, getConnections, iterator

	public void removeConnection(Town n2) {
		if (this.connections.contains(n2))
		{
			this.connections.remove(n2);
			n2.removeConnection(this);
		}
	}

	//get index position of the vertex
	public int getPosition(List<Town> townList) {
		if (townList.indexOf(this) == -1)
			townList.add(this);

		return townList.indexOf(this);
	}

	public ArrayList<Town> getConnections() {

		ArrayList<Town> list = new ArrayList<>();
		Iterator<Road> i = connections.listIterator();
	    while (i.hasNext())
	    {
	        Road n = i.next();
	        list.add(n);
	    }
		return list;
	}

	@Override
	public boolean equals(Object other)
	{
		return (other instanceof Town && other == this);
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