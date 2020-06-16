package ArrayMatriX;

//one traversal , time and space O(m*n)
class Rotate90Degree1 {
    public void rotate(int[][] matrix) {
        int m = matrix.length,n=matrix[0].length;
        int[][]mat = new int[m][n];
        int col=n-1;
        
        for(int row[] : matrix){
            int r=0;
            for(int i : row) mat[r++][col]= i;
            col--;
        }
        
        for(int x=0;x<m;x++){
            for(int c=0;c<n;c++){
                matrix[x][c] = mat[x][c];
            }
        }  
    }
}

// two traversal O(1) space, time o(m*n)
class Rotate90Degree2 {
        public void rotate(int[][] matrix) {  
            int n= matrix[0].length;
            //reverse each row
            for(int rows[] : matrix){
                int j = n-1;
                int i = 0;
                while(i<=j){
                    int temp = rows[i];
                    rows[i++] = rows[j];
                    rows[j--] = temp;
                }
            }
            
            //swap (start from rightmost side)
            //swap(1st row,last col), (2nd row,(last-1) col), (3rd row, (last-2)col).. and so on
            int c = n-1;
            int r1=0,c2=c;
            while(c!=0){
                int c1 = c2-1;
                int r2 = r1+1;
                while(c1>=0 && r2<n){
                    int temp = matrix[r1][c1];
                    matrix[r1][c1--]=matrix[r2][c2];
                    matrix[r2++][c2]=temp;
                }
                r1++; c2--; c--;
            }
        } 
}

//one traversal o(m*n) time, O(1) space;
class Rotate90Degree3{
    static void rotate90Clockwise(int a[][]){ 
    int N = 4;
    // Traverse each cycle 
    for (int i = 0; i < N / 2; i++){ 
        for (int j = i; j < N - i - 1; j++){ 
            // Swap elements of each cycle 
            // in clockwise direction 
            int temp = a[i][j]; 
            a[i][j] = a[N - 1 - j][i]; 
            a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j]; 
            a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i]; 
            a[j][N - 1 - i] = temp; 
        } 
     } 
    }
}



