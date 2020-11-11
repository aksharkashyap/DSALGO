package DP.LcsVaratiations;
//given a string - find longest palindromic susequence
class LongestPalindromicSubsequence{

	static int lps_(char[] txt, char[] pat,int m, int n){
		int dp[][] = new int[m+1][n+1];

		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)  dp[i][j] = 0;
				else if(txt[i-1] == pat[j-1]) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); 
			}
		}

		return dp[m][n];
	}


	public static void main(String[] args) {
		String txt = "akashar"; //given string
		String reversed = new StringBuilder(txt).reverse().toString(); // we reversed it
		char[] t = txt.toCharArray();
		char[] p = reversed.toCharArray();
		int m = t.length;
		int n = p.length;
		int ans = lps_(t,p,m,n);
		System.out.println(ans);
	}
}

//aplicaion question -> min number of deletion to make it palindrome
//return string_length - dp[m][n]

//min number of insertion to make it palindrome
//return string_length -> dp[m][n]
//-> insertion ke liye pair banane honge jo element (string_length-LPS) bache hue hi unka
// ya to unhe delete kr do
//hence->  #numofInsertion = #numofDeletion