package com.seeburger.threads;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;

public class RunDirectoryTransport {
	public static void main(String[] args) throws IOException {

		try {
			Supervisor checkingForFiles = new Supervisor();
			boolean flag = true;
			while(flag) {	
				Thread t1 = new Thread(checkingForFiles);  

				t1.start();
							
				if (source.listFiles().length == 0) {
					t1.wait(10000);
				}
				System.out.println("message = " + str);
				if (str.equals("end"))	{
					flag = false;
				}

			}
			
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			
		}		
	}
}
