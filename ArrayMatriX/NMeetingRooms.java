package ArrayMatriX;
import java.util.PriorityQueue;
import java.util.Arrays;

class NMeetingRooms{

    static void solve(Pair[]arr, int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		int x = 0;
        for(int i=0;i<n;i++){
            if(pq.size()>0){
				x = pq.poll();
				if(arr[i].start >= x) pq.offer(arr[i].end);
				else {
                    pq.offer(x);
                    pq.offer(arr[i].end);
                }
            }
			else pq.offer(arr[i].end);
        }
        System.out.println(pq.size());
    }


    public static void main(String[] args) {
        int[][] lectures = {{0, 5}, {1, 2}, {1, 10}};
        int n = 3;
        Pair[]arr = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(lectures[i][0],lectures[i][1]);
        }
        Arrays.sort(arr);
        solve(arr,n);
    }

    static class Pair implements Comparable<Pair>{
        int start,end;
        Pair(int s, int e){start=s;end=e;}
        public int compareTo(Pair ob){
            return start == ob.start ? end - ob.end : start - ob.start;
        }
        public String toString(){
            return start +" "+ end;
        }
    }
}