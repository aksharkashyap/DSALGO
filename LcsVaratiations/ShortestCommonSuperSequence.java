package LcsVaratiations;

class ShortestCommonSupersequence{

	static int lcs_scs(char[] txt, char[] pat,int m, int n){
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

		//printing
		int i=m,j=n;
		StringBuilder str = new StringBuilder();
		while(i>0 && j>0){
			if(txt[i-1] == pat[j-1]){
				str.append(txt[i-1]);
				i--;j--;
			}
			else if(txt[i-1] > pat[j-1]){
				str.append(txt[i-1]);
				i--;
			}
			else{
				str.append(pat[j-1]);
				j--;
			}
		}
		while(i>0){ //if left
			str.append(txt[i-1]);
			i--;
		}
		while(j>0){ //if left
			str.append(pat[i-1]);
			j--;
		}

		str.reverse();
		System.out.println(str.toString());

		return (m+n)-dp[m][n];
	}


	public static void main(String[] args) {
		String txt = "akshar";
		String pat = "kaf";
		char[] t = txt.toCharArray();
		char[] p = pat.toCharArray();
		int m = t.length;
		int n = p.length;
		int ans = lcs_scs(t,p,m,n);
		System.out.println(ans);
	}
}