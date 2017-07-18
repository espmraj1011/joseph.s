package b;

import java.util.HashMap;

public class Map {
	  public static void main(String args[]) {
	  HashMap<Integer, String> newmap = new HashMap<Integer, String>();
      
	   // populate hash map
	   newmap.put(1, "tutorials");
	   newmap.put(2, "point");
	   newmap.put(3, "is best");
	      
	   System.out.println("Map value before change: "+ newmap);
	      
	   HashMap<Integer, String> newmap1 = new HashMap<Integer, String>();
	   // put new values at key 3
	   String prevvalue=(String)newmap.put(3,"is great");
	      
	   newmap1.putAll(newmap);
	   // check returned previous value
	   System.out.println("Returned previous value: "+ prevvalue);
	      
	   System.out.println("Map value after change: "+ newmap1.get(1));
	   }    
}
