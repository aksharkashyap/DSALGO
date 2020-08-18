//package _CP_Template;

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{   
  
    public int scoreOfParentheses(String s) {
		int mult = 1;
		int score = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				if (s.charAt(i+1) == '(') {
					mult *= 2;
				} else {
					score += mult;
					i++;
				} 
			} else {
				mult = mult/2;
			}
		}
		return score;
	}
}