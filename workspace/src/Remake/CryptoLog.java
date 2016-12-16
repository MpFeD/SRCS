package Remake;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class CryptoLog {
	
	public CryptoLog() {
		int i;
		String res = "";
		try {
			Reader r = new FileReader("/dev/stdin");
			Writer w = new FileWriter("/users/nfs/Etu5/3000755/abc.log");
			CesarWriter cw = new CesarWriter(w,2);
			while (true) {
				i = r.read();
				if ((char) i == '#')
					break;
				System.out.print((char) (i));
				res+=(char)i;
			}
			cw.write(res,2,res.length());
			r.close();
			w.close();
			cw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}