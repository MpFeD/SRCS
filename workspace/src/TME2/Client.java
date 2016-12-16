package TME2;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {

	public Client() {
		Socket c = new Socket();
		InetSocketAddress localhost = new InetSocketAddress("localhost", 8001);
		try {

			c.connect(localhost);

			String res = "";
			char buf = 0;

			InputStream i = new BufferedInputStream(System.in);

			while (true) {
				buf = (char) i.read();
				if (buf == 'X') {
					break;
				}
				if (buf == '\n') {
					res +="\n"+Character.MIN_VALUE;
				} else
					res += buf;
			}
			res += "\n";
			i.close();

			System.out.println(res);

			// res = "GET test lol\n";
			OutputStream os = c.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			/*
			 * dos.writeBytes("a\n"); dos.writeBytes("\n");
			 */

			dos.writeBytes(res);
			dos.writeBytes("\n");

			InputStream is = c.getInputStream();
			InputStreamLiner isl = new InputStreamLiner(is);

			String ligne = "";
			res = "";
			while ((ligne = isl.readLineUnix()).compareTo("") != 0)
				res += ligne + "\n";

			System.out.println(res);

			dos.close();
			os.close();
			isl.close();
			is.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client s = new Client();

	}

}
