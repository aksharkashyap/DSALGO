package MatrixChainMultiplication;

class PalindromePartitioning{
   

    static boolean isPalindrome(char arr[],int i , int j){
       
        while(i<j)
            if(arr[i++] != arr[j--]) 
                return false;
    
        return true;
    }
    
    static int solve(char arr[], int i , int j){
        int ans = Integer.MAX_VALUE;
        if(i>=j ||isPalindrome(arr,i,j)) return 0;
        
        for(int k=i;k<=j-1;k++){
                int temp = solve(arr, i, k) + solve(arr, k+1, j) + 1;
                if(ans>temp) ans=temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        char mat[]= {'n','i','t','i'};
        int i=0,j=mat.length;
        int an = solve(mat,i,j-1);
        System.out.print(an);
    }
}