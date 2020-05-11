package HeapVariations;

import java.util.*;

public class KClosestElements {

     static public class Pair<T>{
        private T key;
        private T value;
        Pair(T key,T value){
            this.key = key;
            this.value = value;
        }
        public T getKey(){
            return key;
        }
        public T getValue(){
            return value;
        }
    } 
    /*
    public static void main(String[] args) {
        int arr[] = {5,6,7,8,9};
        int k = 3;
        int x = 7;
        PriorityQueue<Pair<Integer>> heap = new PriorityQueue<>((a,b) -> b.getKey()-a.getKey()); //max heap ( for min heap - (a-b)

        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            heap.offer(new Pair<Integer>(Math.abs(x-val),val));
            if(heap.size()>k)  heap.poll();
        }

        while(!heap.isEmpty())
            System.out.println(heap.poll().getValue());
    }
*/

    public static void main(String[] args) {
        int arr[] = {5,6,7,8,9};
        int k = 3;
        int x = 7;

        Map<Integer,Integer> map = new HashMap<>();

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey()); //max heap ( for min heap - (a-b)

        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            map.put(Math.abs(x-val),val);
        }

         for(Map.Entry m : map.entrySet()){
                heap.offer(m);
                if(heap.size()>k)  heap.poll();
         }

        while(!heap.isEmpty()){
                Map.Entry m = heap.poll();
                System.out.println(m.getKey()+" " + m.getValue());
        }

    }
}