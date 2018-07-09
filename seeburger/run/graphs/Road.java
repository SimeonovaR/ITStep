package com.seeburger.algorithms.graphs;

public class Road {

	private double distance;
	private Town town1;
	private Town town2;

	public Road(Town town1, Town town2, double distance) {
		this.town1 = town1;
		this.town2 = town2;
		this.distance = distance;

		this.town1.addConnection(this);
		this.town2.addConnection(this);
	}

	public double getDistnace() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Town getTown1() {
		return town1;
	}

	public void setTown1(Town town1) {
		this.town1 = town1;
	}

	public Town getTown2() {
		return town2;
	}

	public void setTown2(Town town2) {
		this.town2 = town2;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Road) {
            if (town1.equals(((Road) other).town1) && (town2.equals(((Road) other).town2) && distance == (((Road) other).distance))) {
                return true;
            }
        }
        return false;
	}

	@Override
	public String toString() {
		return "The distance between " + town1 + " and " + town2 + " is " + distance;
	}

}
