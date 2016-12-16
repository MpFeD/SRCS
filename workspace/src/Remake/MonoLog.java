package Remake;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class MonoLog {
	
	public MonoLog() {
		int i;
		try {
			Reader r = new FileReader("/dev/stdin");
			Writer w = new FileWriter("/users/nfs/Etu5/3000755/abc");
			while (true) {
				i = r.read();
				if ((char) i == '#')
					break;
				w.write((char)i);
				System.out.print((char) (i));
			}
			r.close();
			w.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	

}
