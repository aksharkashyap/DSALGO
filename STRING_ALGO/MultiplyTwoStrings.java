package STRING_ALGO;

//https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
class MultiplyTwoStrings {
        public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
   
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}





//my solution
class MultiplyTwoStrings_AK {
    public String multiply(String num1, String num2) {
        int n2 = num2.length();
        int n1 = num1.length();
       
        if(num1.charAt(0)=='0' || num2.charAt(0)=='0') return "0";
        
        StringBuilder[] str = new StringBuilder[n2];
        char[] arr_num1 = num1.toCharArray();
        
        for(int i=n2-1, k=0; i>=0; i--,k++){
            str[k] = mult(arr_num1, toInt(num2.charAt(i)),k);
        }
    
        if(str.length == 1) return str[0].toString();
        
        StringBuilder curr = str[0];
        
        for(int i=1;i<str.length;i++){
            curr = add(curr,str[i]);
        }
        return curr.toString();
    }
    
    
    StringBuilder add(StringBuilder a, StringBuilder b){
        int n1 = a.length()-1, n2 = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        
        while(n1>=0 && n2>=0){
            int num = toInt(a.charAt(n1)) + toInt(b.charAt(n2)) + carry;
            if(num / 10 == 0) carry = 0;
            else{ num = num % 10; carry = 1; }
            sb.append(num);
            n1--; n2--; 
        }
        
        while(n1>=0){
            int num = toInt(a.charAt(n1)) + 0 + carry;
            if(num / 10 == 0) carry = 0;
            else{ num = num % 10; carry = 1; }
            sb.append(num);
            n1--; 
        }
        
        while(n2>=0){
            int num = 0 + toInt(b.charAt(n2)) + carry;
            if(num / 10 == 0) carry = 0;
            else{ num = num % 10; carry = 1; }
            sb.append(num);
            n2--; 
        }
        if(carry>0) sb.append(carry);
        return sb.reverse();
    }
                                  
    StringBuilder mult(char[] num1, int n, int numZeros){
        StringBuilder sb = new StringBuilder("");
        while(numZeros-- > 0) sb.append("0");
        int carry = 0, i = num1.length-1;
        while(i>=0){
            int num = toInt(num1[i]) * n + carry;   //multiply single digit
            if(num / 10 == 0) carry = 0;
            else{
                carry = num / 10;
                num = num % 10;
            }
            sb.append(num); i--;
        }
        if(carry > 0) sb.append(carry);
        return sb.reverse();
    }
    
    int toInt(char ch){
        return ch-48;
    }
}