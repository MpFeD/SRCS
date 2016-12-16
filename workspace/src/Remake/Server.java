package Remake;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;


public class Server {
	int NbClient = 3;
	int i;
	String res = "";

	public Server() {
		try {
			// Thread.sleep(5000);
			ServerSocket s = new ServerSocket(8080);
			@SuppressWarnings("unused")
			InetSocketAddress localhost = new InetSocketAddress("localhost",
					8080);
			 while (NbClient > 0) {
			Socket c = s.accept();
			SocketAddress ici = c.getLocalSocketAddress();
			SocketAddress labas = c.getRemoteSocketAddress();
			System.out.println("Mon port est : " + ici
					+ " le port de mon interlocuteur est " + labas);

			Thread ts = new ThreadServer(c);
			ts.start();

			

			 NbClient--;
			 }
			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
