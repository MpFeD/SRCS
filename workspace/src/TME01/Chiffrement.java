package TME01;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class Chiffrement {

	CesarWriter cw;

	public Chiffrement(String fichier, int decalage) {
		try {
			this.cw = new CesarWriter(new OutputStreamWriter(
					new FileOutputStream(fichier + ".Cesar")), decalage);
			InputStream b = new FileInputStream(fichier);

			String res = "";
			int x;
			while ((x = b.read()) != -1)
				res += Character.toString((char) x);

			cw.write(res, 0, res.length());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Chiffrement c = new Chiffrement("/users/nfs/Etu5/3000755/def", 2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("erreur");
			e.printStackTrace();
		}
		System.out.println("Fin du programme");

	}
}
