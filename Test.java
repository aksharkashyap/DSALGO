import java.util.*;

class Test {

	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int i=2;
		int num=1;
		int space=h;
		if(h==2) System.out.print("*");
		else{
			for(int k=space+1;k>=0;k--) System.out.print(" "); space--;
			System.out.println("*");
			while(i<h){
				for(int k=space;k>=0;k--) System.out.print("  "); space--;
				System.out.print("*"+"  ");
				for(int j=num;j>0;j--) System.out.print("+"+"  ");
				System.out.println("*" +"  ");
				num+=2;
				i++;
				System.out.println();
			}
			System.out.print("  ");
			for(int j=num+2;j>0;j--) System.out.print("*"+"   ");
		}

	}
}

