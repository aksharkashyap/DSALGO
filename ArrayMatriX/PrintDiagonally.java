package ArrayMatriX;
//print diagonally from top to down
public class PrintDiagonally {
    
   static void print_diag(int mat[][],int n){
        for(int k=0;k<n;k++){
            int row = 0;
            int col = k;
            while(col>=0){
                System.out.print(mat[row][col]+" ");
                row++;col--;
            }
        }

        for(int j=1;j<n;j++){
            int col=n-1,row=j;
            while(row<n){
                System.out.print(mat[row][col] + " ");
            }
        }
   }

    public static void main(String[] args) {
        
    }
}