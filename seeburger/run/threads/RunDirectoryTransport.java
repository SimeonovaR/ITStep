package com.seeburger.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunDirectoryTransport {
	
    private static boolean running = true;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
	static File source = new File("C:" + File.separator + "Users" + File.separator + "MKA" 
            + File.separator + "Desktop" + File.separator + "NIKI KOD");
    static File dest = new File("C:" + File.separator + "Users" + File.separator + "MKA" 
            + File.separator + "Desktop" + File.separator + "ralitsa");
    
	public static void main(String[] args) throws IOException {
        DirectoryContentTransport transportThread = new DirectoryContentTransport(source, dest);
        transportThread.start();
    	try {
            while (running) {
            	if ((reader.readLine()).equals("end")) {
            		running = false;
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
}
