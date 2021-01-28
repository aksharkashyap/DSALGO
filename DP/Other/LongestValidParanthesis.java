package DP.Other;

import java.util.Stack;

class LongestValidParanthesis {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        int max=0,left=0;
        //we will find the longest valid parentheses ending at every i'th index and keep track of the maximum one
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') left++;
            else if(left>0){
                dp[i] = dp[i-1] + 2; //current length
                dp[i] += (i-dp[i]) >= 0 /*checking for valid index*/ ? dp[i-dp[i]] : 0; //previous contiguous valid length + curr length
                max = Math.max(max,dp[i]);
                left--;
            }
        }
        return max;
    }
}

//solution 2
/**
 * Instead of finding every possible string and checking its validity, we can make use of stack while scanning the 
 * given string to check if the string scanned so far is valid, and also the length of the longest valid string. 
 * In order to do so, we start by pushing -1−1 onto the stack.
For every \text{‘(’}‘(’ encountered, we push its index onto the stack.
For every \text{‘)’}‘)’ encountered, we pop the topmost element and subtract the current element's index from the 
top element of the stack, which gives the length of the currently encountered valid string of parentheses. 
If while popping the element, the stack becomes empty, we push the current element's index onto the stack. 
In this way,we keep on calculating the lengths of the valid substrings, and return the length of the longest valid string at the end.
 */
class LVP_Stack {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> stack = new Stack<>();
        int max=0;
        stack.push(-1);
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
              stack.push(i);
            }
            else{
                stack.pop();
                if(!stack.isEmpty()) max = Math.max(max,i-stack.peek());
                else stack.push(i);
            }
        }
        return max;
    }
}
   
//without extra space
/**
 * In this approach, we make use of two counters leftleft and rightright. 
 * First, we start traversing the string from the left towards the right and for every \text{‘(’}‘(’ encountered, 
 * we increment the leftleft counter and for every \text{‘)’}‘)’ encountered, we increment the rightright counter. 
 * Whenever leftleft becomes equal to rightright, we calculate the length of the current valid string and keep 
 * track of maximum length substring found so far. If rightright becomes greater than leftleft we reset leftleft and 
 * rightright to 00.

Next, we start traversing the string from right to left and similar procedure is applied.
 */
class LVP_3{
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}