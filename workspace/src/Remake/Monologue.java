package Remake;

import java.io.FileReader;
import java.io.Reader;

public class Monologue {

	public Monologue() {
		int i;
		try {
			Reader r = new FileReader("/dev/stdin");
			while (true) {
				i = r.read();
				if ((char) i == '#')
					break;
				System.out.print((char) (i));
				r.close();
			}
		} catch (Exception e) {
			System.out.println();
		}
	

	}

}
