package com.shpach.shipstoport;

public class Main {
	public static void main(String[] args) {
		Port port = new Port(2);
		Ship shipOne = new Ship("Maersk II", 30);
		Ship shipTwo = new Ship("Volgodon", 20);
		Ship shipThree = new Ship("Kap. Kaluga", 45);
		shipOne.EnterToPort(port, new PortCall(true, 25));
		shipTwo.EnterToPort(port, new PortCall(true, 25));
		shipThree.EnterToPort(port, new PortCall(true, 35));

	}
}
