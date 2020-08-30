package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

class ShortestSubarrayWithSumAtleastK {
    public int shortestSubarray(int[] A, int K) {
     int n = A.length, ans = n+1;
     int[] prefixSum = new int[n+1];
 
     for (int i = 0; i < n; i++) prefixSum[i+1] = prefixSum[i] + A[i];
     
     Deque<Integer> startIndices = new ArrayDeque<>();
 
     for (int endIdx = 0; endIdx <= n; endIdx++) {
         while (!startIndices.isEmpty() && prefixSum[endIdx] - prefixSum[startIndices.peekFirst()] >= K) { //got the valid condition
             ans = Math.min(ans, endIdx - startIndices.pollFirst()); //try to shorten the length (contract the window)
         }
 
         while (!startIndices.isEmpty() && prefixSum[startIndices.peekLast()] >= prefixSum[endIdx]) {
             startIndices.pollLast(); //to keep the queue in increasing order of starting points (reason : P[y]-k >= p[x])
         }
 
         startIndices.addLast(endIdx); // add the endIdx to queue, since it may used as a start index later
     }
 
     return ans == n+1 ? -1 : ans;
     }
 }