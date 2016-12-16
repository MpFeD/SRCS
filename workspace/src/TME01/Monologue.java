package TME01;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Monologue {

	public static void main(String[] args) {
		int buf = 0;
		String res = "";
		// TODO Auto-generated method stub
		InputStream is = new BufferedInputStream(System.in);

		try {
			while ((buf = is.read()) != 4) {
				if ((char) buf == '\n') {
					System.out.println(res);
					res = "";
				} else
					res += (char) buf;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin du programme");

	}

}
