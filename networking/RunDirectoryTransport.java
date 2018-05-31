package com.seeburger.threads;

import java.io.File;
import java.io.IOException;

public class RunDirectoryTransport {
	public static void main(String[] args) throws IOException {
		File source = new File("C:\\Users\\MKA\\Documents\\ralitsa");
		File dest = new File("C:\\Users\\MKA\\Desktop");
		DirectoryContentTransport.moveFiles(source, dest);

	}
}
