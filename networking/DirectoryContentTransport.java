package com.seeburger.threads;

import java.io.File;
import java.io.IOException;

public class DirectoryContentTransport {

	
	public static void moveFiles(File source, File dest) throws IOException {
		//get a list of files in  source directory
		File[] files = source.listFiles(); 
		//for each file in the source directory -> move
		for(File file: files){
		    System.out.println(source + File.separator + file.getName());

		    String srcFile = (source + File.separator + file.getName());
		    String newDestFile = (dest + File.separator + file.getName());

		    File newFile = new File(srcFile);
		    //renames the file which is specified
		    newFile.renameTo(new File(newDestFile));
		}
	}
	
	public static void reachBottomOfDirectory(File srcFolder, File destFolder) throws IOException {
		File[] listOfFiles = srcFolder.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory() && !file.isHidden()) {
				System.out.println(file.getAbsolutePath());
				moveFiles(file,destFolder);
				reachBottomOfDirectory(file, destFolder);
			}
		}
	}

}
