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
    PriorityQueue<Pair> heap;
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
