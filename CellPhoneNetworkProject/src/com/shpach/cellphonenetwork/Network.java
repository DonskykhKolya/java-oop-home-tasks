package com.shpach.cellphonenetwork;

import java.util.*;

public class Network {
	private String name;
	private HashSet<String> phonesNumbersList = new HashSet<String>();

	public Network(String name) {
		super();
		this.name = name;
	}

	public Network() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addToNetwork(String d) {
		if (!phonesNumbersList.add(d)) {
			System.out.println("phone number allready registered");
		}
	}

	public boolean hasPhone(String number) {
		if (phonesNumbersList.contains(number))
			return true;
		return false;
	}

	public boolean initConnection(String callingNumber, String number) {
		if (hasPhone(callingNumber) && hasPhone(number))
			return true;
		return false;
	}

	public void deleteFromNetwork(String number) {
		phonesNumbersList.remove(number);

	}

	@Override
	public String toString() {
		return "Network [name=" + name + ", phonesNumbersList=" + phonesNumbersList + "]";
	}
	

}
