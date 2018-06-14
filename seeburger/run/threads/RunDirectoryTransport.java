package com.seeburger.threads;

import java.io.File;
import java.io.IOException;

public class RunDirectoryTransport {
    
	static File source = new File("D:" + File.separator + "proekt Front-end web");
    static File dest = new File("C:" + File.separator + "Users" + File.separator + "Ralitsa" 
            + File.separator + "Desktop" + File.separator + "ralitsa");
    
	public static void main(String[] args) throws IOException {
        DirectoryContentTransport transportThread = new DirectoryContentTransport(source, dest);
        transportThread.start();
        new Supervisor(transportThread).start();
	}
}
