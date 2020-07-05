package ArrayMatriX;
import java.util.*;

//find all contiguos anagram
//m*n (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

class FindAllAnagram {
    public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new ArrayList<>();
            int m = s.length(), n = p.length();
            int count_s[] = new int[26], count_p[] = new int[26];
            char[] p_arr = p.toCharArray(), s_arr = s.toCharArray(); 
            
            for(int i=0;i<n;i++) count_p[p_arr[i]-97]++; //store count of p
    
            for(int i=0;i<=m-n;i++){
                Arrays.fill(count_s,0);
                for(int j=i;j<i+n;j++) count_s[s_arr[j]-97]++;
                if(Arrays.mismatch(count_s,count_p) == -1) list.add(i);    //match count of s with p
            }
            return list;
        }
}

// Simple hash to get the collition of permutation as well 
//( if you choose strong hashing then anagram string will not get matched)
class FindAllAnagram2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int m = s.length(), n = p.length();
        if(m == 0 || n ==0 || m<n) return list; 
        int count_s[] = new int[26], count_p[] = new int[26];
        char[] p_arr = p.toCharArray(), s_arr = s.toCharArray();
        
        for(int i=0;i<n;i++) count_p[p_arr[i]-97]++;

        int hash_s=1,hash_p=1;
        for(int i=0;i<n;i++){
            hash_s = hash_s + s_arr[i];
            hash_p = hash_p + p_arr[i];
         }
        
        for(int i=0;i<=m-n;i++){
            if(hash_s == hash_p){
                Arrays.fill(count_s,0);
                for(int j=i;j<i+n;j++) count_s[s_arr[j]-97]++;
                if(Arrays.mismatch(count_s,count_p) == -1) list.add(i); 
            }
            //role the hash
           if(i+n < m) hash_s = (hash_s - s_arr[i]) + s_arr[i+n];
        }
        return list;
    }
}