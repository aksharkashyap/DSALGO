import java.util.*;
import java.lang.*;
import java.io.*;

class Test{
/*
Q2) - Given an unsorted array with duplicates. 
Print sorted distinct elements first and then the remaining duplicates.

Input  : [34,12,2,1,67,89,5,67,8,76,12]

Output : [1,2,5,8,12,34,67,76,89,12,67]

[1,2,2,3,4,4]
[1,2,3,4, .....2,4]
O(N^2) brute force -> insertion sort
O(NLogn) sort + two pointers and swap

*/
	static void solve(int[]A,int[]B,int m, int n){
	
	}

	public static void main(String[]args){
		int[]A = {1,2,6};
		int[]B = {1,5};
		int m = A.length, n = B.length;
		solve(A,B,m,n);
	}
}
