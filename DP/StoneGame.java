package DP;
import java.util.Arrays;

class StoneGame {
    boolean solve(int[] piles, boolean alex, int valAlex, int valLee,int start,int end){
    
        if(start>=end) return valAlex > valLee;
        
        if(alex) valAlex += piles[start];
        else  valLee += piles[start];
        
        boolean x = solve(piles,!alex,valAlex,valLee,start+1,end);
     
        
        if(alex) valAlex += piles[end] - piles[start];
        else valLee += piles[end] - piles[start];
        
        boolean y = solve(piles,!alex,valAlex,valLee,start,end-1);
       
        return x || y;
    }
    public boolean stoneGame(int[] piles) {
        return solve(piles, true,0,0,0,piles.length-1);
    }
}

class StoneGameMinMax {
    int memo[][][];
    
    int solve(int[]piles, int start, int end, int id){
        if(start > end) return 0;
        if(memo[start][end][id] != -1) return memo[start][end][id];
        int next = Math.abs(1-id);
        if(id == 0){
          memo[start][end][id] = Math.max(solve(piles,start+1,end,next)+piles[start], 
                                          solve(piles,start,end-1,next)+piles[end]);
        }else{
          memo[start][end][id] = Math.min(solve(piles,start+1,end,next)-piles[start],
                                          solve(piles,start,end-1,next)-piles[end]);
        }
        return memo[start][end][id];                                
    }
    
    public boolean stoneGame(int[] piles) {
        memo = new int[piles.length+1][piles.length+1][2];
        for(int[][] mat : memo)
            for(int[] arr : mat)
                Arrays.fill(arr,-1);
        return solve(piles,0,piles.length-1,0) >=0 ;
    }
}