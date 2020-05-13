package MatrixChainMultiplication;
/*
The first and the only argument of input will contain a string, A.
The string A, may contain these characters:
    '|' will represent or operator 
    '&' will represent and operator
    '^' will represent xor operator
*/
public class EvaluateExpressionToTrue {

   static boolean evaluate(char[]arr, int i,int k, int j){
        boolean oprnd1,oprnd2,exp=false;
        if(arr[i]=='T') oprnd1 = true;
        else oprnd1 = false;

        if(arr[j]=='T') oprnd2 = true;
        else oprnd2 = false;

        if(arr[k] == '|') exp = oprnd1 | oprnd2;
        else if(arr[k] == '&') exp = oprnd1 & oprnd2;
        else if(arr[k] == '^') exp = oprnd1 ^ oprnd2;

        return exp;
    }

    static int ans = 0;
    static int solve(char[] arr, int i,int k, int j) {
        
        if (i > j-1){
            return 0;
        }

        if(evaluate(arr, i, k, j)) return 1;

        for (k = i; k < j; k += 1) {
            int left, right;
            left = solve(arr, i,i+1, k);
            right = solve(arr, k + 1,k+2, j);
            int temp = left + right;
            if(ans < temp) ans= temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "F|T&T";
        char arr[]= str.toCharArray();
        int i=0,j=arr.length;
        int an = solve(arr,i,i+1,j-1);
        System.out.print(an);
    }
}