package HashTable;

import java.util.*;

//Prison cell after n days
class PrisonCell {
    //brute force
    public int[] prisonAfterNDays(int[] cells, int N) {
        int len = cells.length;
        int temp[] = new int[cells.length];
        
        while(N-- > 0){
            Arrays.fill(temp,0);
            for(int i=1;i<len-1;i++){
                if(cells[i-1]==0 && cells[i+1] == 0 || cells[i-1]==1 && cells[i+1] == 1 ) temp[i] = 1;
                else temp[i] = 0;
            }
            cells = Arrays.copyOf(temp,temp.length);
        }
        return cells;
    }
}


class PrisonCell2 {
    public int[] prisonAfterNDays(int[] cells, int N){
        int len = cells.length;
        int temp[] = new int[cells.length];
        Set<String> seen = new HashSet<>();
        int cycleLen=0;
        for(int n=0;n<N;n++){
            Arrays.fill(temp,0);
            for(int i=1;i<len-1;i++){
                if(cells[i-1]==0 && cells[i+1] == 0 ||
                   cells[i-1]==1 && cells[i+1] == 1 ) 
                    temp[i] = 1;
                else temp[i] = 0;
            }
            if(!seen.add(Arrays.toString(temp))){ //got the cycle
                //just skip the remaining items by taking modulo (by using the cycle fact)
                //and return the remainder(this many time we need to run the loop finally to get the answer)
                return prisonAfterNDays(cells,N % cycleLen);    
            }
            cells = Arrays.copyOf(temp,temp.length);
            cycleLen++;
        }
        return cells;
    }
}

/**
 * hashSet or array lookup using modulo,simulate (from 0) until you hit the cycle and record the 
 * length of cycle, after that call the function after taking remainder to get the final arrays) 
 * [As, after first iteration first and last cell will be fix with 0 so left over only 6 cells - and
 *  we have 2 choices 0 or 1 so how many total combinations we have? = 2^6 = 64 with this we can 
 * confirm patterns will repeate definitely]

 */