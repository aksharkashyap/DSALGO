package DP;
import java.util.Arrays;
//recursive
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
//using minimax
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

class Other{
// si -> Starting Index, ei -> Ending Index
// turn -> If True then Alex's turn else Lee's turn
public static int gameOnInt(int[] piles, int si, int ei, boolean turn){ 

    if(si > ei){
         return 0;
     }

if(turn){ // If its Alex's Turn
    int rr1 = gameOnInt(piles, si + 1,ei,false) + piles[si]; //Consuming from Starting Index
    int rr2 = gameOnInt(piles, si,ei - 1,false) + piles[ei]; //Consuming form Ending Index
    return Math.max(rr1, rr2); //Choosing the Maximum From both of the results
}

// If it is Lee's Turn
int rr1 = gameOnInt(piles, si + 1, ei, true) - piles[si]; //Consuming from the Starting Index
int rr2 = gameOnInt(piles, si, ei - 1, true) - piles[ei];//Consuming from the Ending Index
return Math.min(rr1, rr2); // Choosing the Minimum from the Recursion Result
}
}

class SolutionMemo2D {
    int memo[][];
    public static int gameOnIntTD(int[] piles, int si, int ei, boolean turn, int[][] strg){
       if(si > ei){
           return 0;
       }
       // If the Recursion has Calculated the Answer  
       if(strg[si][ei] > 0){
           return strg[si][ei]; // return that Stored Answer
       }
       if(turn){ // If it is Alex's Turn
           int rr1 = gameOnIntTD(piles, si + 1,ei,false, strg) + piles[si]; // Same as Above
           int rr2 = gameOnIntTD(piles, si,ei - 1,false, strg) + piles[ei]; // Same as Above
           strg[si][ei] = Math.max(rr1, rr2); // Storing the max ans at particular indices
           return strg[si][ei];
       }
       // If it is Lee's Turn
       int rr1 = gameOnIntTD(piles, si + 1, ei, true, strg) - piles[si]; //Same logic as above
       int rr2 = gameOnIntTD(piles, si, ei - 1, true, strg) - piles[ei];//Same logic as above
       strg[si][ei] = Math.min(rr1, rr2); //Storing the answer at particular indices
       return strg[si][ei];
   }
       
       public boolean stoneGame(int[] piles) {
           memo = new int[piles.length+1][piles.length+1];
           return gameOnIntTD(piles,0,piles.length-1,true,memo)>=0;
       }
   }