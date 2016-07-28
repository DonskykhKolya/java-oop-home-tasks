package com.shpach.cellphonenetwork;

public class Phone {
	private String myNumber;
	private Network netWork;

	public Phone(String myNumber) {
		super();
		this.myNumber = myNumber;
	}

	public String getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(String myNumber) {
		this.myNumber = myNumber;
	}

	public void registerToNetwork(Network netWork) {
		netWork.addToNetwork(myNumber);
		this.netWork = netWork;
	}

	public void unRegisterFromNetwork() {
		if (netWork != null) {
			netWork.deleteFromNetwork(myNumber);
		}
		this.netWork = null;
	}

	public void call(String number) {
		if (number == myNumber) {
			System.out.println("Can't call to yourself");
			return;
		}
		if (netWork != null) {
			if (netWork.hasPhone(myNumber)) {
				if (netWork.initConnection(myNumber, number)) {
					System.out.println("Beep ..... Beep.....Beep");
				} else {
					System.out.println("Wrong number");
				}
			} else {
				System.out.println("Your phone is not registered in network");
			}
		} else {
			System.out.println("Your phone is not registered in network");
		}
	}

	@Override
	public String toString() {
		if (netWork != null) {
			if (netWork.hasPhone(myNumber)) {
				return "Phone [myNumber=" + myNumber + ", netWork=" + netWork.getName() + "]";
			}
		}
		return "Phone [myNumber=" + myNumber + ", netWork= not registerd]";
	}
	

}
