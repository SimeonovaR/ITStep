package com.seeburger.algorithms.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Town
{
	// Any data members can be defined
	private String name;
	private double distnace;
	
	// Connectivity to other nodes
	private List<Town> connections;

	public Town()
	{
		this.connections = new ArrayList<Town>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistnace() {
		return distnace;
	}

	public void setDistance(double distnace, Town dest) {
		this.distnace = distnace;
		//dest.setDistance(this.distnace, this);
	}

	public void addConnection(Town n2)
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
		Iterator<Town> i = connections.listIterator();
	    while (i.hasNext())
	    {
	        Town n = i.next();
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


}
