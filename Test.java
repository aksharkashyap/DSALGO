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
            if(!seen.add(Arrays.toString(temp))){
                return prisonAfterNDays(cells,N % cycleLen);
            }
            cells = Arrays.copyOf(temp,temp.length);
            cycleLen++;
        }
        return cells;
    }
}

/**
 * iterative inorder,postoder,pre
 */