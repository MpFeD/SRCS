package Remake;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class Chiffrement {
	
	
	public Chiffrement(String in){
		int i;
		String res = "";
		try {
			Reader r = new FileReader(in);
			Writer w = new FileWriter(in+".Cesar");
			CesarWriter cw = new CesarWriter(w,2);
			while ((i = r.read())!=-1) {
				System.out.print((char) (i));
				res+=(char)i;
			}
			cw.write(res,0,res.length());
			r.close();
			w.close();
			cw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
