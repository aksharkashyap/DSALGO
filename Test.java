import java.util.*;
import java.lang.*;
import java.io.*;

class Test{
/*
*/
	
	public static void main(String[]args){
		Set<int[]> set = new HashSet<>();
		int[]arr = {3};
		int[]x = {3};
		set.add(arr);
		set.add(x);
		System.out.println(set.size());
	}
}

