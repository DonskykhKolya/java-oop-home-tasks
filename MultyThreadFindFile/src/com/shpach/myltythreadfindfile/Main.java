package com.shpach.myltythreadfindfile;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		FindFile rn=new FindFile(new File("."), "1.txt");
		Thread th= new Thread(rn);
		th.start();

	}

}
