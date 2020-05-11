package MatrixChainMultiplication;

class PalindromePartitioning{
    static int ans = Integer.MAX_VALUE;
    
    static int solve(int arr[], int i , int j){
        
        if(i>=j) return 0;
        
        for(int k=i+1;k<j;i++){
                int temp = solve(arr, i, k) + solve(arr, k+1, j) + arr[i]*arr[k]*arr[j];
                if(ans>temp) ans=temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int mat[]= {1,2,3,4,3};
        int i=1,j=mat.length;

        int an = solve(mat,i,j-1);
        System.out.print(an);
    }
}