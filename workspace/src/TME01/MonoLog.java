package TME01;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MonoLog {

	public static void main(String[] args) {
		int buf = 0;
		String res = "";
		// TODO Auto-generated method stub
		InputStream is = new BufferedInputStream(System.in);

		try {
			OutputStream os = new FileOutputStream("/users/nfs/Etu5/3000755/abc");
			while ((buf = is.read()) != 4) {
				os.write(buf);
				if ((char) buf == '\n') {
					System.out.println(res);
					res = "";
				} else
					res += (char) buf;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur");
			e.printStackTrace();
		}
		System.out.println("Fin du programme");

	}

}
