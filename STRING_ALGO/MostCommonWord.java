package STRING_ALGO;
import java.util.*;

class MostCommonWord {
    public String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
/**
 *  \\W+ Replace all occurances non word items(symbols,white spaces etc)
 * \\s+ Replace all occurances of whitespace
 */

class SolutMostCommonWord2 {
    public String mostCommonWord(String paragraph, String[] banned) {
        StringBuilder sb = new StringBuilder(paragraph.replaceAll("[^\\dA-Za-z ]", " "));
        String[] str = sb.toString().split(" ");
        Map<String,Integer> freq = new HashMap<>();
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        
        for(String s : str){
            String s_lower = s.toLowerCase().trim();
            if(!s_lower.equals("") && !bannedWords.contains(s_lower)) 
                freq.put(s_lower, freq.getOrDefault(s_lower,0)+1);
        }
        String res = "";
        int count=0;
        for(Map.Entry<String,Integer> m : freq.entrySet()){
            if(count < m.getValue()){
                res = m.getKey();
                count = m.getValue();
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/most-common-word/