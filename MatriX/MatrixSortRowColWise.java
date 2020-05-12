package MatriX;
/* sort the matrix row and column wise
Time Complexity: O(n2log2n).
Auxiliary Space: O(1).

method -> 
sort(row) 
transpose
sort
transpose
*/

import java.util.Arrays;

public class MatrixSortRowColWise {
    
    public static void main(String[] args) {
        int mat[][] = { { 4, 1, 3 }, 
                        { 9, 6, 8 }, 
                        { 5, 2, 7 } }; 
        int n = 3; 
      
        System.out.print("Original Matrix:\n"); 
        printMat(mat, n); 
        sortMatRowAndColWise(mat, n); 
        System.out.print("\nMatrix After Sorting:\n"); 
        printMat(mat, n); 
    }

    private static void sortMatRowAndColWise(int[][] mat, int n) {
        sort(mat, n);
        transpose(mat, n);
        sort(mat, n);
        transpose(mat, n);
    }

    private static void sort(int[][]mat,int n){
        for(int i=0;i<n;i++)
            Arrays.sort(mat[i]);
    }

    private static void transpose(int mat[][], int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    private static void printMat(int[][] mat, int n) {

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(mat[i][j]+" ");
            
            System.out.println();
        }
        
    }
}