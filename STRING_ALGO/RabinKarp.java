package STRING_ALGO;

class RabinKarp{
	static final int ALPHA = 256;
	static void search(String pat, String txt,int q){
		int M = pat.length();
		int N = txt.length();
		int h =1;
		int hash_m=0,hash_n=0;

		for(int i=0;i<M-1;i++)
			h = (h * ALPHA ) % q;

		for(int i=0;i<M;i++){
			hash_m = hash_m * ALPHA + (pat.charAt(i))%q;
			hash_n = hash_n * ALPHA + (txt.charAt(i))%q;			
		}
		int i,j;
		for(i=0;i<N-M;i++){

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

	public static void main(String[] args) {
		String txt = "GEEKS FOR GEEKS"; 
        String pat = "GEEK"; 
        int q = 101; // A prime number 
        search(pat, txt, q);
	}
}