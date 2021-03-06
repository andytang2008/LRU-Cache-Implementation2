import java.util.LinkedHashMap;
import java.util.Map;
 
class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity)
    {
        CAPACITY = capacity;
        //map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			map = new LinkedHashMap<Integer, Integer>() {
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
				System.out.println("Size="+size()+"   Capacity="+CAPACITY);
                return size() > CAPACITY;
            }
        };
    }
 
    // This method works in O(1)
    public int get(int key)
    {
        System.out.println("Going to get the value " +
                               "for the key : " + key);
        return map.getOrDefault(key, -1);
    }
 
    // This method works in O(1)
    public void set(int key, int value)
    {
        System.out.println("Going to set the (key, " +
             "value) : (" + key + ", " + value + ")");
        map.put(key, value);
    }
	
	
	    public void display()
		{
			System.out.println("--------------------------------------");
			for(Map.Entry<Integer,Integer>it:map.entrySet()){
				  System.out.print("  key="+it.getKey()+", ");
				   System.out.println("  value="+it.getValue()+", ");
				  }
			System.out.println("--------------------------------------");
			System.out.println();
		}
		
}
 
public class LRU {  //TestLRUCacheWithLinkedHashMap
 
    public static void main(String[] args)
    {
        System.out.println("Going to test the LRU "+
                           " Cache Implementation");
        LRUCache cache = new LRUCache(2);
		cache.display();
  
        // it will store a key (1) with value
        // 10 in the cache.
        cache.set(1, 10);
		cache.display();
 
        // it will store a key (1) with value 10 in the cache.
        cache.set(2, 20);
		cache.display();
        System.out.println("Value for the key: 1 is " +
                           cache.get(1)); // returns 10
 
        // evicts key 2 and store a key (3) with
        // value 30 in the cache.
        cache.set(3, 30);
		cache.display();
		
		
        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found)
 
        // evicts key 1 and store a key (4) with
        // value 40 in the cache.
        cache.set(4, 40);
		cache.display();
		
		
        System.out.println("Value for the key: 1 is " +
               cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " +
                           cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " +
                           cache.get(4)); // return 40
 
    }
}