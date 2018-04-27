package networking;

public class Main {
	public static void main(String[] args) {
		Runnable runClient = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				Client client = new Client();
				client.clientConnectTo("192.168.100.7", 6000);
			}
		};
		
		Runnable runServer = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Server server = new Server();
				server.starServr(600);
				
			}
		};
		
		Thread thread1 = new Thread(runClient);
		Thread thread2 = new Thread(runServer);
		thread1.start();
		thread2.start();
	}
}
