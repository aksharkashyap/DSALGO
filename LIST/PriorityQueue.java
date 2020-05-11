package LIST;
import java.util.*;

class Max implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b){
        return b-a;
    }
}

class PriorityQueueEx {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Max());
        pq.add(34);
        pq.add(10);
        pq.add(10);
        pq.add(33);
        System.out.println(pq.poll());
    }
}