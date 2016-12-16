package TME6.cache;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

import org.omg.CORBA.StringHolder;

import cache.FileSystemPOA;

public class FileSystemImpl extends FileSystemPOA {

	@Override
	public boolean lire(String ref, StringHolder data) throws Exception {
		
		Reader r;
		try {
			r = new FileReader(ref);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}

		StringBuffer sb = new StringBuffer();
		int i;
		
		while ((i = r.read()) != -1) {
			sb.append((char) i);
		}
		
		data.value = sb.toString();
		
		r.close();
		
		return true;
	}

	@Override
	public boolean ecrire(String ref, String data) throws Exception {
		// TODO Auto-generated method stub
		
		Writer w;
		try {
			w = new FileWriter(ref);
		} catch (FileNotFoundException e) {
			return false;
		}

		w.write(data);
		
		w.close();
		
		return true;

	}

	@Override
	public boolean majCache(String ref, String data) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("majCache");
		return false;
	}
	// ici se trouve le code du serveur de fichier
}
