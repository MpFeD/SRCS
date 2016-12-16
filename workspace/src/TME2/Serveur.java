package TME2;

import java.io.DataOutputStream;
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Serveur {

	public Serveur() {

		try {
			/*
			 * Temporisateur
			 */
			// Thread.sleep(5000);

			ServerSocket s = new ServerSocket(8001);
			Socket c = new Socket();

			c = s.accept();

			InputStream is = c.getInputStream();
			InputStreamLiner isl = new InputStreamLiner(is);
			

			String res = "";
			String ligne="";

			while ((ligne = isl.readLineUnix()).compareTo("")!=0)
				res += ligne +"\n";
			
			System.out.println(res);
			

			OutputStream os = c.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			/*
			dos.writeBytes("b\n");
			dos.writeBytes("\n");
			*/
			Thread ts = new ThreadServeur(res,c);
			ts.start();
			s.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Serveur s = new Serveur();

	}

}
