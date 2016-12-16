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
import java.net.Socket;
import java.net.SocketAddress;

public class HttpRequest {

	String request;
	Socket c;
	String cmd;
	String fic;
	String version = "";
	String entetes = "";
	File fichier;

	boolean entetesExistantes = false;

	public HttpRequest(String request, Socket c) {
		this.request = request;
		this.c = c;
	}

	public void processRequest() {

		cmd = request.substring(0, 3);
		int len = 4;
		while (request.charAt(len++) != ' ')
			;
		fic = request.substring(4, len - 1);
		fichier = new File(fic);

		while (true) {
			version += request.charAt(len);
			len++;
			if (len == request.length())
				break;
			if (request.charAt(len) == '\n')
				break;
		}

		/*
		 * System.out.println(cmd); System.out.println(fic);
		 * System.out.println(version); System.out.println(len);
		 * System.out.println(request.length());
		 */
		if (len != request.length())
			entetes = request.substring(len + 2, request.length()) + "\n";
		else
			entetes = "\n";

		if (cmd.equals("GET"))
			processGet(request);
		else if (cmd.equals("PUT"))
			processPut(request);
		else
			System.out.println("Mauvaise requete");
	}

	public void processGet(String str) {
		try {
			OutputStream os = c.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			String res = "";
			if (fichier.exists()) {

				String contenuFic = "";
				InputStream is = new FileInputStream(fic);
				InputStreamReader lecture = new InputStreamReader(is);
				BufferedReader buff = new BufferedReader(lecture);
				String ligne;
				while ((ligne = buff.readLine()) != null)
					contenuFic += ligne;

				System.out.println("contenu = " + contenuFic);

				res += "HTTP/1.0 200 OK\n";
				res += "Content-Length : " + contenuFic.length() + "\n";
				res += "Content-type : text/html\n";
				res += entetes;
				res += contenuFic;

				System.out.println(res);
				dos.writeBytes(res);

				buff.close();
				lecture.close();
				is.close();

			} else {
				res = "HTTP/1.0 404 Not found\nerreur";
				dos.writeBytes(res);
			}
			dos.close();
			os.close();
			c.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void processPut(String str) {
		try {
			OutputStream os = c.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			int i=0;
			String res = "";
			if (fichier.exists()) {

				System.out.println("entetes :" + entetes);
				
				while(entetes.charAt(i++) !='\n');
				
				
				i++;
				String contenuFic = entetes.substring(i, entetes.length());
				System.out.println("contenu :" + contenuFic);

				OutputStream oso = new FileOutputStream(fic);
				OutputStreamWriter ostr = new OutputStreamWriter(oso);
				ostr.write("<HTML><BODY>" + contenuFic + "</BODY></HTML>");

				ostr.close();
				oso.close();

				res += "HTTP/1.0 200 OK\n";
				dos.writeBytes(res);
				dos.writeBytes("\n");
			} else {
				res += "HTTP/1.0 404 Not found\n";
				dos.writeBytes(res);
				dos.writeBytes("\n");
			}

			dos.close();
			os.close();
			c.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
