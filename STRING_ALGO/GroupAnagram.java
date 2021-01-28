package STRING_ALGO;
import java.util.*;

//approaches- Trie, count, sorting

/**
 * Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a 
 * string in strs. The outer loop has complexity O(N) as we iterate through each string. 
 * Then, we sort each string in O(KlogK) time.
 * 
 * Space Complexity: O(NK) the total information content stored in ans.
 */
class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            char[] sc = s.toCharArray();
            Arrays.sort(sc); //we can use count sort as well for better complexity
            String newStr = String.valueOf(sc);
            if(!map.containsKey(newStr)) map.put(newStr, new ArrayList<>());
            map.get(newStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}


class GroupAnagram2 {
 /**
 * Time Complexity: O(NK), where N is the length of strs, and K is the maximum length of a string in strs. 
 * Counting each string is linear in the size of the string, and we count every string.
 * Space Complexity: O(NK), the total information content stored in ans.
 */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        int count[] = new int[26];
        for(int i=0;i<strs.length;i++){
            Arrays.fill(count,0);
            String s = strs[i];
            char[] sc = s.toCharArray();
            for(char c : sc) count[c-'a']++;
            StringBuilder STR = new StringBuilder("");
            for(int k=0;k<26;k++) STR.append(count[k]);
            String newStr = STR.toString();
            if(!map.containsKey(newStr)) map.put(newStr, new ArrayList<>());
            map.get(newStr).add(s);        
        }
        return new ArrayList<>(map.values());
    }
}
