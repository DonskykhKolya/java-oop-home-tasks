package com.shpach.filescopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.shpach.filescopy.IOUtils.InputParamNotDirExeption;

public class Main {

	public static void main(String[] args) {
		
		//Copy files with filter extention
		MyFileFilter mFF = new MyFileFilter("doc", "csv");
		File folderFrom = new File("a");
		File folderTo = new File("b");
		if (!folderTo.exists())
			folderTo.mkdirs();
		try {
			IOUtils.copyFiles(folderFrom, folderTo, mFF);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InputParamNotDirExeption e) {
			System.out.println(e.getMessage());
		}
		
		//save similar words in different files
		try {
			IOUtils.saveSimilarInTextFiles(new File("similar", "a.txt"), new File("similar", "b.txt"), new File("similar", "c.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		

	}

}
