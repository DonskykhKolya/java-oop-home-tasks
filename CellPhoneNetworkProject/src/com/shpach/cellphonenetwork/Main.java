package com.shpach.cellphonenetwork;

public class Main {
	public static void main(String[] args) {
		Network nw = new Network("DeadCell");
		Phone ph1 = new Phone("0971112231");
		ph1.registerToNetwork(nw);
		Phone ph2 = new Phone("0971112232");
		ph2.registerToNetwork(nw);
		Phone ph3 = new Phone("0971112233");
		ph3.registerToNetwork(nw);
		System.out.println(nw);
		ph1.call(ph2.getMyNumber());
		ph1.call(ph1.getMyNumber());
		ph2.call("0971134244");
		ph2.unRegisterFromNetwork();
		ph1.call(ph2.getMyNumber());
		ph2.call(ph1.getMyNumber());
		System.out.println(nw);
		System.out.println(ph1);
		System.out.println(ph2);
		

	}
}
