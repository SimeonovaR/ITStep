package com.seeburger.threads;

import java.io.File;
import java.io.IOException;

public class DirectoryContentTransport {

	public static void moveFiles(File source, File dest) throws IOException {
		//get a list of files in  source directory
		File[] files = source.listFiles(); 
		//for each file in the source directory -> move
		for(File file: files){
		    System.out.println(source + "\\" + file.getName());

		    String srcFile = (source + "\\" + file.getName());
		    String newDestFile = (dest + "\\" + file.getName());

		    File newFile = new File(srcFile);
		    //renames the file which is specified
		    newFile.renameTo(new File(newDestFile));
		}
	}
}
