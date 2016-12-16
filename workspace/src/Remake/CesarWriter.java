package Remake;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CesarWriter extends FilterWriter {

	int decalage;

	protected CesarWriter(Writer out, int n) {
		super(out);
		decalage = n;
		// TODO Auto-generated constructor stub
	}

	public void write(String str, int off, int len) {
		String res = str.substring(0, off);
		int i = 0;
		for (i = off; i < len; i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'z')
				res += (char) ('a' + ((str.charAt(i) + -'a' + decalage) % 26));
			else
				res += str.charAt(i);
		}
		try {
			super.write(res, 0, len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
