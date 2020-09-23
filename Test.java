import java.util.*;
import java.io.*;

// do question on comparator and comparablee
class Test {
	
	static void solve(String str, String pat){
		int m = str.length();
		int n = pat.length();
		int p = 53;
		int power_of_p = 1;
		int MOD = (int) 1e9+9;
		int str_hash = 0, pat_hash = 0;

		for(int i=0;i<n;i++){
			str_hash = (str_hash + (str.charAt(i)-'a'+1) * power_of_p) % MOD;
			pat_hash = (pat_hash + (pat.charAt(i)-'a'+1) * power_of_p) % MOD;
			if(i<n-1) power_of_p = (p * power_of_p ) % MOD;
		}

		for(int i=0;i<=m-n;i++){
			
			if(str_hash == pat_hash){
				int j=0;
				while(j<n && str.charAt(i+j) == pat.charAt(j)) j++;
				if(j == n) System.out.println(i);
			}
			if(i+n < m){
				str_hash = (str_hash - (str.charAt(i)-'a'+1)) % MOD; //remove left
				str_hash = (str_hash / p ) % MOD; // shift power 
				str_hash = (str_hash + (str.charAt(i+n)-'a'+1) * power_of_p) % MOD; // add right
			}
			if(str_hash < 0) str_hash += MOD;
		}
		
	}
	public static void main(String[] args) throws IOException {
	
		String str = "abcabcabcabcabcdfsababababfjsdf";
		String pat = "ab";
		solve(str,pat);
	}
}
