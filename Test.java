class Test{

	static void solve(char[] str, int n){

		for(int len = 1;len<=n;len++){ //len 
			for(int i=0;i<=n-len;i++){
				int j = len+i-1;
				for(int k=i;k<=j;k++)
					System.out.print(str[k]);
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		char[] str = {'a','b','c'};
		solve(str,3);
	}
}