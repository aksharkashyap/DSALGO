package DP.Other;
import java.util.Arrays;

public class MinCostTicket {
        int min= Integer.MAX_VALUE;
        int[] duration = {1,7,30};
        
        void solve(int day,int cost,int currPlan, int[] days, int[] costs){
            
            if(day == days.length){
                min = Math.min(min,cost);
                return;
            }
            
            if(currPlan<days[day]){
                for(int c=0;c<3;c++)
                    solve(day+1,cost+costs[c],days[day]+duration[c]-1,days,costs);
            }
            else solve(day+1,cost,currPlan,days,costs);
        }
        
        public int mincostTickets(int[] days, int[] costs) {
            solve(0,0,0,days,costs);
            return min;
        }
}

//memoization
class MinCostTicket2 {
    int[] duration = {1,7,30};
    int[] memo = new int[366];
    
    int solve(int day,int currPlan, int[] days, int[] costs){
        while(day<days.length && currPlan >= days[day]) day = day+1;
        if(memo[day]!=-1) return memo[day];
        if(day == days.length) return 0;
        int ans= Integer.MAX_VALUE;
        for(int c=0;c<3;c++){
           int temp = solve(day+1,days[day]+duration[c]-1,days,costs)+costs[c];
           ans = Math.min(ans,temp);
        }
        return memo[day]=ans;
    }
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(memo,-1);
        return solve(0,0,days,costs);
    }
}