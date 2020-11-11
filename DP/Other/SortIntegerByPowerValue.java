package DP.Other;
import java.util.Comparator;
import java.util.PriorityQueue;

class SortIntByPower {
    int memo[] = new int[1000001]; //given constraint 10^3 so taken double because of multiplications
    int solve(int x){
        
        if(memo[x] != 0) return memo[x]; // if already calculated then return its steps
        
        if(x == 1) return 1;
        if((x&1) == 0) return memo[x] = solve(x>>1)+1;
        return memo[x] = solve(3*x+1)+1;
    }
    
    public int getKth(int lo, int hi, int k) {
       
        PriorityQueue<pair> heap = new  PriorityQueue<>(new Sort()); //min heap
        
        for(int x=lo;x<=hi;x++){
            int c = solve(x);
            heap.offer(new pair(x,c-1));
        }
        int g = k-1;
        while(g-->0) heap.poll();
        return heap.poll().f;
    }
    
    class pair{
        int f,s;
        pair(int f, int s){
            this.f=f;
            this.s=s;
        }
    }
    
    class Sort implements Comparator<pair>{
        public int compare(pair a, pair b){
            if(a.s != b.s) return a.s-b.s;
            return a.f-b.f;
        }
    }
}