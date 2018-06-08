package com.seeburger.threads;

import java.io.File;
import java.io.IOException;

public class RunDirectoryTransport {
    private static boolean running = true;
    private static Supervisor supervisorThread;
    
	File source = new File("C:" + File.separator + "Users" + File.separator + "Ralitsa"  
            + File.separator + "ralitsa");
    File dest = new File("C:" + File.separator + "Users" + File.separator + "Ralitsa" 
            + File.separator + "Desktop");
    
	public static void main(String[] args) throws IOException {
        supervisorThread = new Supervisor("supervisorThread");
        supervisorThread.start();
        
	    try {
			Supervisor checkingForFiles = new Supervisor("supervisorThread");
			boolean flag = true;
			while(running) {	
				
			}
			
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			
		}		
	}
}