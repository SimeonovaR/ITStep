package com.seeburger.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Supervisor extends Thread {
    private BufferedReader reader;

    private boolean running = true;

    public Supervisor(String name) {
        super(name);
        
            
    }
    

    
	@Override
	public void run() {



		try {
			DirectoryContentTransport.reachBottomOfDirectory(source, dest);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}