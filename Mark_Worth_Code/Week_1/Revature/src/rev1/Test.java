package rev1;
import java.util.Map;

import java.util.HashMap;
import java.util.WeakHashMap;

public class Test{
    
    public static void main(String[] args) { 
 
           
        // Created HashMap and WeakHashMap objects

        Map hashmapObject = new HashMap();
        Map weakhashmapObject = new WeakHashMap();
        
       // Created HashMap and WeakHashMap keys

        String hashmapKey = new String ("hashmapkey");
        String weakhashmapKey = new String ("weakhashmapkey");

      // Created HashMap and WeakHashMap values

        String hashmapValue = "hashmapvalue";
        String weakhashmapValue = "weakhashmapvalue";  

      // Putting key and value in HashMap and WeakHashMap Object

        hashmapObject.put(hashmapKey ,hashmapValue); 
        weakhashmapObject.put(weakhashmapKey ,weakhashmapValue); 

      // Print HashMap and WeakHashMap Object : Before Garbage Collection
       
        System.out.println("HashMap before Garbage Collected :"+ hashmapObject);
        System.out.println("WeakHashMap before Garbage Collected :"+
                            weakhashmapObject);

     // Set HashMap and WeakHashMap Object keys to null

        hashmapKey = null;  
        weakhashmapKey = null;

     // Calling Garbage Collection
        System.gc(); 

    // Print HashMap and WeakHashMap Object : After Garbage Collection
       
        System.out.println("HashMap after Garbage Collected :"+ hashmapObject);
        System.out.println("WeakHashMap after Garbage Collected :"+
                            weakhashmapObject); 
 }
}