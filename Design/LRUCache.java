package Design;
import java.util.*;
//gives tle for large input
//to remove lru - reheapfy at the time -> when you change time of an element 
class LRUCache {
    int CAP;
    int TIME=0;
    PriorityQueue<Pair> heap;
    Map<Integer,Pair> map;
    List<Pair> list;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        heap = new PriorityQueue<>(new Sort());
        list = new ArrayList<>();
        CAP = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Pair obj = map.get(key);
        obj.setTime(++TIME);
        reheap(obj);
        return obj.val;
    }
    
    void reheap(Pair obj){
        list .clear();
        while(heap.peek() != obj){
            list.add(heap.poll());
        }
        list.add(heap.poll());
        for(Pair ob : list) heap.offer(ob);
    }
    
    public void put(int key, int value) {
       TIME++;
       if(map.containsKey(key)){
         Pair obj = map.get(key);
         obj.setVal(value);
         obj.setTime(TIME);
         reheap(obj);
       }
       else if(map.size()< CAP){
         Pair obj = new Pair(key,value,TIME);
         map.put(key,obj);
         heap.offer(obj);
       }
       else{
           //remove lru
         int K = heap.poll().key;
         map.remove(K);
         Pair obj = new Pair(key,value,TIME);
         map.put(key,obj);
         heap.offer(obj);
       }
      
    }
    
    class Sort implements Comparator<Pair>{
        public int compare(Pair a, Pair b){
            return a.time - b.time;
        }
    }
    
    public class Pair{
        int key,val,time;
        Pair(int k, int v, int t){
            key=k; val=v; time=t;
        }
        void setTime(int t){
            time = t;
        }
        void setVal(int v){
            val = v;
        }
    }
}



 //Approach 2 : Only use hashmap (accepted)
 //  to remove lru traverse map

 class LRUCache2 {
    int CAP;
    int TIME=0;
    Map<Integer,Pair> map;
    public LRUCache2(int capacity) {
        map = new HashMap<>();
        CAP = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Pair obj = map.get(key);
        obj.time = ++TIME;
        return obj.val;
    }
    
    int traverse_map(){
        Pair a = null;
        int min=Integer.MAX_VALUE;
        for(Pair x : map.values()){
            if(x.time < min){
                a = x;
                min = x.time;
            }
        }
        return a.key;
    }
    
    public void put(int key, int value) {
       TIME++;
       if(map.containsKey(key)){
         Pair obj = map.get(key);
         obj.val = value;
         obj.time = TIME;
       }
       else if(map.size()< CAP){
         Pair obj = new Pair(key,value,TIME);
         map.put(key,obj);
       }
       else{
           //remove lru// traverse map
         map.remove(traverse_map());
         Pair obj = new Pair(key,value,TIME);
         map.put(key,obj);
       }
      
    }
    
    public class Pair{
        public int key,val,time;
        Pair(int k, int v, int t){
            key=k; val=v; time=t;
        }
    }
}

//3 (o(1))

class Node { 
    int key,value; 
    Node pre,next; 
    public Node(int key, int value){ 
        this.key = key; 
        this.value = value; 
    } 
} 

class LRUCache3 {
    
    private HashMap<Integer, Node> map; 
    private int capicity,count; 
    private Node head, tail;
    
    public LRUCache3(int capacity) {
        this.capicity = capacity; 
        map = new HashMap<>(); 
        head = new Node(0, 0); 
        tail = new Node(0, 0); 
        head.next = tail; 
        tail.pre = head; 
        head.pre = null; 
        tail.next = null; 
        count=0;
    }
    
    // This method works in O(1) 
    public int get(int key){ 
        if(map.get(key) == null) return -1; 
        Node node = map.get(key); 
        int result = node.value; 
        deleteNode(node); 
        addToHead(node); 
        return result; 
    }
    
    public void put(int key, int value) {
        if (map.get(key) != null) { 
            Node node = map.get(key); 
            node.value = value; 
            deleteNode(node); 
            addToHead(node); 
        } 
        else { 
            Node node = new Node(key, value); 
            map.put(key, node); 
            if (count < capicity){
                count++;
                addToHead(node); 
            } 
            else { 
                map.remove(tail.pre.key); 
                deleteNode(tail.pre); 
                addToHead(node); 
            } 
        } 
    }
  
    public void deleteNode(Node node){ 
        node.pre.next = node.next; 
        node.next.pre = node.pre; 
    } 
  
    public void addToHead(Node node){ 
        node.next = head.next; 
        node.next.pre = node; 
        node.pre = head; 
        head.next = node; 
    } 
 
  }


  //4 for java
class LRUCache4 { 

	Set<Integer> cache; 
	int capacity; 

	public LRUCache4(int capacity) 
	{ 
		this.cache = new LinkedHashSet<Integer>(capacity);  //it keeps order based on the insertion time
		this.capacity = capacity; 
	} 

	// This function returns false if key is not 
	// present in cache. Else it moves the key to 
	// front by first removing it and then adding 
	// it, and returns true. 
	public boolean get(int key) 
	{ 
		if (!cache.contains(key)) 
			return false; 
		cache.remove(key); 
		cache.add(key); 
		return true; 
	} 

	/* Refers key x with in the LRU cache */
	public void refer(int key) 
	{		 
		if (get(key) == false) 
		put(key); 
	} 

	// display contents of cache 
	public void display() 
	{ 
		Iterator<Integer> itr = cache.iterator(); 
		while (itr.hasNext()) { 
			System.out.print(itr.next() + " "); 
		} 
	} 
	
	public void put(int key) 
	{ 
		// If already present, then 
		// remove it first. Note that 
		// we are going to add later 
		if (cache.contains(key)) 
			cache.remove(key); 

		// If cache size is full, remove the least 
		// recently used. 
		else if (cache.size() == capacity) { 
			int firstKey = cache.iterator().next(); 
			cache.remove(firstKey); 
		} 

		cache.add(key); 
	} 
} 
