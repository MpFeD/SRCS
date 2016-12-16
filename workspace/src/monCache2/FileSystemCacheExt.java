package monCache2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import org.omg.CORBA.StringHolder;

public class FileSystemCacheExt extends FileSystemCachePOA {

	@Override
	public boolean lireM(String ref, StringHolder data) throws Exception {
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
	public boolean ecrireM(String ref, String data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean majCache(String ref, String data) {
		// TODO Auto-generated method stub
		return false;
	}

}
