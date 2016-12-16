package TME01;


import java.io.OutputStreamWriter;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientAffiche {
	public ClientAffiche() {
		boolean refuse = true;
		while (refuse) {
			Socket c = new Socket();
			InetSocketAddress localhost = new InetSocketAddress("localhost",
					8082);

			refuse = false;
			try {

				c.connect(localhost);
				SocketAddress ici = c.getLocalSocketAddress();
				SocketAddress labas = c.getRemoteSocketAddress();

				System.out.println("Mon port est : " + ici
						+ " le port de mon interlocuteur est " + labas);

				InputStream is = new BufferedInputStream(System.in);

				String res = "";
				int buf = 0;

				while ((buf = is.read()) != 'X') {
					if ((char) buf == '\n') {
						break;
					} else
						res += (char) buf;
				}

				OutputStream os = c.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				CesarWriter cw = new CesarWriter(osw, 2);
				
				cw.write(res);
				c.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				refuse = true;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Erreur connexion");
			}
		}

	}
}
