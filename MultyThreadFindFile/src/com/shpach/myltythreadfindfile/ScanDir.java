package com.shpach.myltythreadfindfile;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ScanDir implements Runnable {
private ExecutorService exSer;
private ArrayList<String> result;
String fileName;
private File dir;
private AtomicInteger threadsCounter;
public ScanDir(ExecutorService exSer, ArrayList<String> result, String fileName, File dir, AtomicInteger threadsCounter) {
	super();
	this.exSer = exSer;
	this.result = result;
	this.fileName = fileName;
	this.dir = dir;
	this.threadsCounter=threadsCounter;
}

	@Override
	public void run() {
		File[] fileList = dir.listFiles();
		for ( File file : fileList) {
			if(file.isDirectory()){
				this.threadsCounter.incrementAndGet();
				exSer.execute(new ScanDir(exSer,result,fileName,file, this.threadsCounter));
			}else{
				if(file.getName().equals(fileName)){
					result.add(file.getAbsolutePath());
				}
			}
		}
		threadsCounter.decrementAndGet();
		
	}

	

}
