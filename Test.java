import java.util.*;

//Prison cell after n days
class Test {
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

/**
 * iterative inorder,postoder,pre
 */