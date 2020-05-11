package BinarySearchProblems;
// approach - start from the rightmost corner
//leetcode - Search a 2D Matrix II and I ( problem desc are diff but sol same)
//given row and columnwise sorted matrix find an element
//o(n+m) 

//leetcode - Search a 2D Matrix I
/**Q-1 Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
 */
//leetcode - Search a 2D Matrix II
/**Q-2Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
 */
public class RowColumnSortedMatrix {
    
    static String binary_search(int[][]mat, int row, int col,int n,int key){

        while(row<n && col >=0){

            int mid = mat[row][col];
            if(mid == key) return row+" "+col;
            if(key<mid){
                    col = col-1;
            }
            if(key > mid){
                row = row+1;
            }
        }
        return "Not found";
    }

    public static void main(String[] args) {
        int mat[][]={
            {-1,3}
            };
        int n= mat.length;
        int key=3;
        System.out.println(n + " " + mat[0].length);
        String ans = binary_search(mat,0,mat[0].length-1,n,key);    
        System.out.print(ans);


        /**
         *   if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
             int row_len = matrix.length;
             int col_len = matrix[0].length;
             return binary_search(matrix,0,col_len-1,row_len,target);
         */
    }
}