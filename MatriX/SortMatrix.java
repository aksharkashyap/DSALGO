package MatriX;
//sort the matrix in all way increasing order
/**
 * approach -1-> traverse the matrix and store the elements in temp[n*m] then sort the temp
 * time compl -> O(n*nlogn) 
 * space compl -> O(n*m)
 */ 

 /**
  * approach -2-> using formula 
  space compl -> O(1)
  time compl > O(n*m)
  */

public class SortMatrix {
    
    public static void main(String[] args) {
        int[][] mat = { { 5, 4, 7 },  
                        { 1, 3, 8 }, 
                        { 2, 9, 6 } }; 
          
        int row = mat.length; 
        int col = mat[0].length; 
        sortMat(mat, row, col); 
        printMat(mat, row, col); 
    }

    private static void sortMat(int[][] mat, int row, int col) {
        int size = row*col;
        for(int i=0;i<size;i++){
            for(int j=0;j<size-1;j++){
                if(mat[j/row][j%row] > mat[(j+1)/row][(j+1)%row]){
                    int temp = mat[j/row][j%row];
                    mat[j/row][j%row] =  mat[(j+1)/row][(j+1)%row];
                    mat[(j+1)/row][(j+1)%row] = temp;
                }
            }
        }
    }

    private static void printMat(int[][] mat, int row, int col) {
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                System.out.print(mat[i][j]+" ");
            System.out.println();
        }
            
    }

}