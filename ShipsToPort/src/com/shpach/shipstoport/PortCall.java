package com.shpach.shipstoport;

public class PortCall{
	private boolean load;
	private int containerValue;
	public PortCall(boolean load, int containerValue) {
		super();
		this.load = load;
		this.containerValue = containerValue;
	}
	public boolean isLoad() {
		return load;
	}
	public int getContainerValue() {
		return containerValue;
	}
	
}