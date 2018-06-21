package com.seeburger.algorithms.graphs;

import java.util.LinkedList;
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
		this.connections = new LinkedList<Road>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addConnection(Road n2)
	{
		if ((!this.connections.contains(n2.getTown1())) || !(this.connections.contains(n2.getTown2())))
		{
			this.connections.add(n2);
			n2.getTown2().addConnection(new Road(n2.getTown2(), this, n2.getDistnace()));
		}
	}

	public void removeConnection(Road n2) {
		if (this.connections.contains(n2))
		{
			this.connections.remove(n2);
			n2.getTown2().removeConnection(new Road(n2.getTown2(), this, n2.getDistnace()));
		}
	}

	//get index position of the vertex
/*	public int getPosition(List<Town> townList) {
		if (townList.indexOf(this) == -1)
			townList.add(this);

		return townList.indexOf(this);
	}*/

	public List<Road> getConnections() {

		List<Road> list = new LinkedList<>();
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
