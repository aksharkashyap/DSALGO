package STRING_ALGO;

public class NaivePatternSearch {

    private static void search_pattern(String txt, String pat){
        int m = txt.length();
        int n = pat.length();

        for(int i=0;i<=m-n;i++){
            int j;
            for(j=0;j<n;j++)
                if(txt.charAt(i+j)!=pat.charAt(j)) break;
            
            if(j == n) System.out.println("Pattern found at "+ i);
            
        }
    }


    public static void main(String[] args) {
            String txt = "abcdefghabcdefg";
            String pattern = "fgh";
            search_pattern(txt, pattern);
    }
}