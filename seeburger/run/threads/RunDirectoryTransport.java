package com.seeburger.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunDirectoryTransport {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	static File source = new File("D:" + File.separator + "proekt Front-end web");
	static File dest = new File("C:" + File.separator + "Users" + File.separator + "Ralitsa" + File.separator
			+ "Desktop" + File.separator + "ralitsa");

	public static void main(String[] args) throws IOException {
		DirectoryContentTransport dirTransport = new DirectoryContentTransport(source, dest);
        Thread transportThread = new Thread(dirTransport);
        transportThread.start();

		try {
			if ((reader.readLine()).equals("end")) {
				transportThread.interrupt();
			}
			transportThread.join();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
