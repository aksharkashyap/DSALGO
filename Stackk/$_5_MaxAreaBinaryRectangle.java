package Stackk;
import java.util.*;

class MABR{

    static int MAH(ArrayList<Integer> v){ //program of max area of histogram 
        int max=0;
        return max;
    }

    static void solve(int mat[][], int n){
        ArrayList<Integer> v = new ArrayList<>();
        for(int j=0;j<n;j++){
           v.add(mat[0][j]);
        }
        int max = MAH(v);
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0) v.set(j,0);
                else v.set(j,v.get(j)+1);
                max = Math.max(max, MAH(v));
            }
        }
        System.out.print(max);
    }
    public static void main(String[] args) {
        
        int mat[][]={
            {0,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,0,0,0}
        };

        solve(mat, mat.length);

    }
}