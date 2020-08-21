
class Test{

	public static void main(String[] args) {
		String str = "abcabcabcabcabccc";
		char[] arr = str.toCharArray();
		int max=0;
		StringBuilder ans = new StringBuilder("");
		for(int i=0;i<arr.length;i++){
			StringBuilder sb = new StringBuilder("");
			int count[] = new int[26];
			int len=0;
			for(int j=i;j<arr.length;j++){
				count[arr[j]-97]++;
				if(count[arr[j]-97] == 1) len++;
				sb.append(arr[j]);
				if(len==2){
					if(j-i>=max){
						ans = sb;
						max = j-i;
					}
				}
				else if(len>2) break;
			}
		}
		System.out.println(ans.toString());
	}
}