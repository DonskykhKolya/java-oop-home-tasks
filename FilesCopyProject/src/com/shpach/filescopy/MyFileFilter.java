package com.shpach.filescopy;
import java.io.File;
import java.io.FilenameFilter;

public class MyFileFilter implements FilenameFilter {
	private String[] filterArr;

	public MyFileFilter(String... filterArr) {
		super();
		this.filterArr = filterArr;
	}

	@Override
	public boolean accept(File dir, String name) {
		for (String string : filterArr) {
			if (name.toLowerCase().endsWith("." + string))
				return true;
		}
		return false;
	}

}
