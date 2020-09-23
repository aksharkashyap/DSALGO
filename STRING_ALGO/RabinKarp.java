package STRING_ALGO;
/**This is simple mathematics, we compute decimal value of current window from previous window.
For example pattern length is 3 and string is “23456”
You compute the value of first window (which is “234”) as 234.
How how will you compute value of next window “345”? You will do (234 – 2*100)*10 + 5 and get 345. */

class RabinKarp{
	static final int ALPHA = 256;
	static void search(String pat, String txt,int q){
		int M = pat.length();
		int N = txt.length();
		int h =1;
		int hash_m=0,hash_n=0;

		for(int i=0;i<M-1;i++)
			h = (h * ALPHA ) % q;  // The value of h would be "pow(ALPHA, M-2)%q" 

		for(int i=0;i<M;i++){
			hash_m = (hash_m * ALPHA + (pat.charAt(i)))%q;
			hash_n = (hash_n * ALPHA + (txt.charAt(i)))%q;			
		}
		int i,j;
		for(i=0;i<=N-M;i++){

			if(hash_m == hash_n){
				//then compare
				for(j=0;j<M;j++){
					if(txt.charAt(i+j) !=pat.charAt(j)) break;
				}
				if(j==M) System.out.println("pattern found at: "+ i);
			}
			//slide window
			if(i<N-M) hash_n = ((hash_n - txt.charAt(i)*h) *ALPHA +txt.charAt(i+M))%q;	
			if(hash_n <0) hash_n += q; //if negative then make it positive
		}


	}


	//my method
	static void rabin_karp_simple(String str, String pat){
		int m = str.length();
		int n = pat.length();
		int p = 53; //if(letter contains both lower/upper) and 31 for lowercase is ideal
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

	public static void main(String[] args) {
		String txt = "superhero"; 
        String pat = "hero"; 
        int q = 101; // A prime number 
        search(pat, txt, q);
	}
}