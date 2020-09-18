import java.util.*;

class Test {

	public static void main(String[] args){

		System.out.println(Arrays.toString("barfoothefoobarman".split("(?<=\\G.{3})")));

	}
	static int val(char ch){return ch-48;}
}

