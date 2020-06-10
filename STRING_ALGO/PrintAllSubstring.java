package STRING_ALGO;

public class PrintAllSubstring {
        //number of substrings = n(n+1)/2;
        //method 1
        public static void SubString(String str, int n) 
        { 
           for (int i = 0; i < n; i++)  
               for (int j = i+1; j <= n; j++) 
                    System.out.println(str.substring(i, j)); 
        } 


        //method 2 
        public static void substring_(char[]str,int n){

            for(int i=0;i<n;i++){ //from ith pos -> how many substrings can be generated
                for(int j=0;j<n-i;j++){ //how many times chars are needed to be printed
                    for(int k=i;k<n-j;k++) //start printing the chars
                        System.out.print(str[k]);
                System.out.println();
                }
                
            }
        }

        //method 3 (if length wise sorting is asked then this is useful)
        static void subString(char str[], int n) { 
            for (int len = 1; len <= n; len++) { //length
                for (int i = 0; i <= n - len; i++) { //how many elements with length 'len'   
                    int j = i + len - 1; 
                    for (int k = i; k <= j; k++) { 
                        System.out.print(str[k]); 
                    } 
                    System.out.println(); 
                } 
            } 
        } 
      
      
        public static void main(String[] args) 
        { 
            String str = "cat"; 
            substring_(str.toCharArray(), str.length()); 
        }   
}