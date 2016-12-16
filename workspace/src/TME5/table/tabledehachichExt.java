package TME5.table;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class tabledehachichExt extends tabledehachichPOA {
	
	Map<String,org.omg.CORBA.Object> maTable;
	
	public tabledehachichExt(){
		maTable = new HashMap<String,org.omg.CORBA.Object>();
	}

	@Override
	public boolean contains(String cle) {
		return maTable.containsKey(cle);
	}

	@Override
	public org.omg.CORBA.Object get(String cle) {
		return maTable.get(cle);
	}

	@Override
	public void put(String cle, org.omg.CORBA.Object valeur) {
		if(maTable.containsKey(cle)==false)
			maTable.put(cle, valeur);
		else
			System.out.println("cle "+ cle +" deja presente");
	}
	
	
}
