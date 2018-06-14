package com.seeburger.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.transform.Source;

public class Supervisor extends Thread {
    private static boolean running = true;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    DirectoryContentTransport transport;
    
    public Supervisor(DirectoryContentTransport transport) {
        this.transport = transport;          
    }
    
    @Override
    public void run() {
    	String consoleCommand = "";
        try {
            while (running) {
            	if ((consoleCommand = reader.readLine()).equals("end")) {
            		running = false;
            	}
            	else {
                    try {
						transport.reachBottomOfDirectory(transport.getSource().getAbsolutePath());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
