package tabledehach;

import java.util.*;

public class Implementation extends tabledehach.ModifPOA{

    public Map<Integer,Integer> table = new HashMap<Integer,Integer>();
    
    public boolean containsKey (int key){
	return table.containsKey((Integer)key);
    }
    public int get (int key){
	return table.get(key);
    }
    public void put (int key, int value){
	table.put(key,value);
    }

    
}
	
