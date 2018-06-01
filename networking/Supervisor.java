package com.seeburger.threads;

import java.io.File;
import java.io.IOException;

public class Supervisor implements Runnable{
	File source = new File("C:" + File.separator + "Users" + File.separator + "Ralitsa"  
            + File.separator + "ralitsa");
    File dest = new File("C:" + File.separator + "Users" + File.separator + "Ralitsa" 
            + File.separator + "Desktop");
    
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
