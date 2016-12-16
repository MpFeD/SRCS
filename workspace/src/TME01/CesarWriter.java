package TME01;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class CesarWriter extends FilterWriter {

	int decalage;

	public CesarWriter(OutputStreamWriter out, int decalage) {
		super(out);
		this.decalage = decalage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void write(String str, int off, int len) {
		String res = "";
		int i;
		/*
		 * Suppression des char spéciaux
		 */
		for (i = 0; i < str.length(); i++) { 
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'z')
				res += Character.toString((char) ((char) 'a' + (str.charAt(i)
						- (char) 'a' + (char) decalage) % 26));
			else
				res +=str.charAt(i);
		}
		try {
			super.write(res, off, len);
			super.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
