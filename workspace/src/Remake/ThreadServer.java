package Remake;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Socket;

public class ThreadServer extends Thread {
	
	Socket c;
	int i;
	String res = "";

	public ThreadServer(Socket c) {
		super();
		this.c = c;
	}

	public void run() {
		try {
			InputStream is = c.getInputStream();
			Reader r = new InputStreamReader(is);

			
			while (true) {
				i = r.read();
				res += (char) i;
				if ((char) i == '\n')
					break;
			}
			System.out.println("Chiffré : ");
			System.out.print(res);	
			
			res="";
			
			while (true) {
				i = r.read();
				res += (char) i;
				if ((char) i == '\n')
					break;
			}
			System.out.println("Déhiffré : ");
			System.out.print(res);	
			
			
			
			OutputStream os = c.getOutputStream();	
			DataOutputStream dos = new DataOutputStream(os);
			
			dos.writeBytes("J'ai bien reçue le message\n");
			
			c.close();
		} catch (Exception e) {

		}
	}
}
