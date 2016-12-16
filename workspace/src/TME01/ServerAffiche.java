package TME01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;


public class ServerAffiche {

	public ServerAffiche() {
		char []cbuf=new char[128];

		try {
			/*
			 * Temporisateur
			 */
			// Thread.sleep(5000);

			ServerSocket s = new ServerSocket(8082);
			
			int i = 2;
			//i=0 pour 3 clients
			while (i < 3) {
				Socket c = new Socket();
				i++;

				c = s.accept();
				SocketAddress ici = c.getLocalSocketAddress();
				SocketAddress labas = c.getRemoteSocketAddress();

				System.out.println("Mon port est : " + ici
						+ " le port de mon interlocuteur est " + labas);
				
				InputStream is = c.getInputStream();
				InputStreamReader isw = new InputStreamReader(is);	
				BufferedReader in = new BufferedReader(isw);
				
				in.read(cbuf);
				System.out.println(cbuf);
				c.close();
			}
			s.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
