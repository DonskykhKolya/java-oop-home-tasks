package com.shpach.shipstoport;

import java.util.concurrent.atomic.AtomicInteger;

import com.shpach.shipstoport.PortCall;

public class Ship implements PortEnter {
	private String name;
	private AtomicInteger containerLoad;
	private int containerCapasity;
	
	public Ship(String name, int containerCapasity) {
		super();
		this.name = name;
		this.containerCapasity = containerCapasity;
		this.containerLoad=new AtomicInteger(0);
	}
	
	public String getName() {
		return name;
	}

	public int getContainerLoad() {
		return containerLoad.get();
	}
	public int getContainerCapasity() {
		return containerCapasity;
	}
	public synchronized void loadUnLoadContainer(boolean load) throws overLoadException, emptyShipException{
		if (load){
			if(containerLoad.get()<containerCapasity)containerLoad.incrementAndGet();
			else throw new overLoadException();
		}
		else{
			if (containerLoad.get()>0)containerLoad.decrementAndGet();
			else throw new emptyShipException();
		}
	}
	public static class overLoadException extends Exception{

		@Override
		public String getMessage() {
			
			return "Ship is full";
		}
	}
	public static class emptyShipException extends Exception{

		@Override
		public String getMessage() {
			
			return "Ship is empty";
		}
	}
	@Override
	public void EnterToPort(Port port, PortCall portCall) {
		Ship ship=this;
		Thread th1= new Thread(new  Runnable(){

			@Override
			public void run() {
				port.enterToPort(ship, portCall, true);
			}
		});
		th1.start();
		
	}

}
