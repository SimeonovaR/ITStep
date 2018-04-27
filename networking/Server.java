package networking;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.*;

public class Server {
	public void starServr(int port) {
		try {
			ServerSocket ss = new ServerSocket(port);
			boolean flag = true;
			while(flag) {				
				Socket s = ss.accept();
				DataInputStream dis = new DataInputStream(s.getInputStream());
				
				String str = (String)dis.readUTF();
				
				System.out.println("message = " + str);
				if (str.equals("zdr"))	{
					flag = false;
					ss.close();
				}

			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
