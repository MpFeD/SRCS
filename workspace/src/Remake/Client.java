package Remake;

import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.io.OutputStream;

public class Client {
	int NoConnexion = 1;
	int NbTentative = 3;
	String res="";
	int i;
	public Client() {
		while (NoConnexion == 1&& NbTentative>0) {
			try {
				InetSocketAddress localhost = new InetSocketAddress(
						"localhost", 8080);
				Socket c = new Socket();
				c.connect(localhost, 8080);
				SocketAddress ici = c.getLocalSocketAddress();
				SocketAddress labas = c.getRemoteSocketAddress();
				System.out.println("Mon port est : " + ici
						+ " le port de mon interlocuteur est " + labas);
				NoConnexion=0;
				
					
				OutputStream os = c.getOutputStream();	
				DataOutputStream dos = new DataOutputStream(os);
				
				Reader r = new FileReader("/dev/stdin");
				
				while (true) {
					i = r.read();
					res+=(char)i;
					if ((char) i == '\n')
						break;
				}
				Writer w = new StringWriter();
				CesarWriter cw =new  CesarWriter(w, 2);	
				cw.write(res, 0, res.length());
				System.out.println(w.toString());
				
				dos.writeBytes(w.toString());
				dos.writeBytes(res);
				
				
				InputStream is = c.getInputStream();
				r = new InputStreamReader(is);

				System.out.println("Réponse du server : ");
				while (true) {
					i = r.read();
					System.out.print((char) (i));
					res += (char) i;
					if ((char) i == '\n')
						break;
				}
				
				
				
				dos.close();
				w.close();
				cw.close();
				os.close();
				c.close();
				
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Connexion échoué, tentatives restantes : "+NbTentative);	
				NbTentative--;
				NoConnexion=1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
