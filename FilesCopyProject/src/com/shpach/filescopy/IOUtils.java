package com.shpach.filescopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

public class IOUtils {
	public static class InputParamNotDirExeption extends Exception {
		@Override
		public String getMessage() {
			return "Input param is not valid";
		}
	}

	public static void copyFiles(File dirFrom, File dirTo, FilenameFilter fnf)
			throws FileNotFoundException, IOException, InputParamNotDirExeption {
		if (dirFrom.exists() && dirTo.exists()) {
			if (dirFrom.isDirectory() && dirTo.isDirectory()) {

				File[] fileList = dirFrom.listFiles(fnf);

				for (File mfile : fileList) {
					try (FileInputStream fio = new FileInputStream(mfile);
							FileOutputStream fos = new FileOutputStream(
									dirTo.getAbsolutePath() + "/" + mfile.getName())) {
						byte[] buff = new byte[4 * 1024];
						int readBytes = 0;
						for (; (readBytes = fio.read(buff)) > 0;) {
							fos.write(buff, 0, readBytes);
						}

					}
				}

			} else {
				throw new IOUtils.InputParamNotDirExeption();
			}
		} else {
			throw new IOUtils.InputParamNotDirExeption();
		}
	}

	public static void saveSimilarInTextFiles(File file1, File file2, File fileSaveTo)
			throws IOException, FileNotFoundException {
		if (!file1.exists() || !file2.exists() || file1.isDirectory() || file2.isDirectory())
			throw new FileNotFoundException();
		StringBuilder sbF1 = IOUtils.readTextFileToStringBuilder(file1);
		StringBuilder sbF2 = IOUtils.readTextFileToStringBuilder(file2);
		StringBuilder sbF3 = new StringBuilder();
		String str1 = sbF1.toString();
		str1 = IOUtils.replacePunctuation(str1);
		String[] wordsArr = str1.split(" ");
		String str2 = sbF2.insert(0, " ").append(" ").toString();
		str2 = IOUtils.replacePunctuation(str2);
		for (String str : wordsArr) {
			if (str2.contains(" " + str + " ")) {
				sbF3.append(str);
				sbF3.append(System.lineSeparator());
			}
		}
		String str3 = sbF3.toString();
		try (FileOutputStream fos = new FileOutputStream(fileSaveTo)) {
			byte[] arr = str3.getBytes();
			int buffLength = 4 * 1024;
			if (buffLength > arr.length)
				buffLength = arr.length;
			for (int i = 0; (arr.length - i) > 0;) {

				fos.write(arr, i, buffLength);
				i += buffLength;
				if (((arr.length - i) < buffLength) && ((arr.length - i) > 0))
					buffLength = (arr.length - i);

			}

		}

	}

	private static String replacePunctuation(String str1) {
		str1 = str1.replaceAll("\\.", " ");
		str1 = str1.replaceAll("\\,", " ");
		str1 = str1.replaceAll("\\!", " ");
		str1 = str1.replaceAll("\\?", " ");
		str1 = str1.replaceAll(System.lineSeparator(), " ");
		return str1;

	}

	private static StringBuilder readTextFileToStringBuilder(File file) throws FileNotFoundException, IOException {
		StringBuilder sb = new StringBuilder();
		char[] buff = new char[1024];
		int readChars = 0;
		try (FileReader fr = new FileReader(file)) {
			for (; (readChars = fr.read(buff)) > 0;) {
				sb.append(buff, 0, readChars);
			}
		}
		return sb;

	}

}
