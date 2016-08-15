package com.shpach.folderlistner;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Start directory listner (\"c\" to cancel):");
		File dir = new File("a");
		if (dir.exists()) {
			if (!dir.isDirectory()) {
				System.out.println("Input param is not directory");
				return;
			}
		} else
			dir.mkdirs();
		Thread mt = new Thread(new DirListnerThread(dir));
		mt.start();
		// start thread
		Scanner sc = new Scanner(System.in);
		for (;;) {
			if (sc.nextLine().equals("c")) {
				
				mt.interrupt();
				break;
			}
		}

		// }
		System.out.println("Directory listner stoped");
	}

}
