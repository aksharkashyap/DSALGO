import java.util.*;
class solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]scores = new int[n];
		for(int i=0;i<n;i++) scores[i] = sc.nextInt();

		for(int i=0;i<n;i++){
			int mult=0;
			if(scores[i] < 38) System.out.println(scores[i]);
			else{
				if(scores[i] % 5 ==0) mult = scores[i] + 5;
				else{
					mult = scores[i] + (5 - (scores[i] % 5));
				}
				int grade = mult - scores[i];
				if(grade < 3) System.out.println(mult);
				else if(scores[i] < 38) System.out.println(scores[i]);
			}
		}
		sc.close();
	}
}
