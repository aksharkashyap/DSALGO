package LcsVaratiations;
// min number of insertion and deletion to convert string a to string b

public class MinInsertionDeletion {

    static String get_ans(char[]a,char[]b,int m,int n){
        int dp[][]=new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0) dp[i][j] =0;
                else if( a[i-1]==b[j-1]) dp[i][j] = 1+ dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j]);
            }
        }
       // int temp = m-dp[m][n];  //a- lcs (deletion degaa) then b-temp... insertion
       // return "insertion:"+temp + "\ndeletion:" + (n-temp);

       int insertion = m-dp[m][n];
       int deln = n-dp[m][n];
       return "insertion:"+insertion + "\ndeletion:" + deln;
    }
    public static void main(String[] args) {
        
        String a = "heap";
        String b = "pea";
        char arr[]=a.toCharArray();
        char brr[]=b.toCharArray();
        String ans = get_ans(arr,brr,arr.length,brr.length);
        System.out.println(ans);
    }
}