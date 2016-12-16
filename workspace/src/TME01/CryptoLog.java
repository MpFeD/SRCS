package TME01;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class CryptoLog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int buf = 0;
		String res = "";
		InputStream is = new BufferedInputStream(System.in);


		try {
			OutputStream os = new FileOutputStream(
					"/users/nfs/Etu5/3000755/def");
			OutputStreamWriter osw = new OutputStreamWriter(os);
			CesarWriter c = new CesarWriter(osw, 2);
			
			while ((buf = is.read()) != 'X') {
				if ((char) buf == '\n') {
					c.write(res,0,res.length());
					res = "";
				} else
					res += (char) buf;
			}
			c.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur");
			e.printStackTrace();
		}
		

		System.out.println("Fin du programme");

	}

}
