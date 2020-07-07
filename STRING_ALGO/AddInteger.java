package STRING_ALGO;
import java.util.HashMap;
//Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2
//built in function and integer conversion from them not allowed

//method 1 : not using built in function but cause overflow
class AddInteger1 {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        if(n1 == 0 && n2 == 0) return "";
        if(n1 == 0) return num2;
        if(n2 == 0) return num1;
        
        HashMap<Character,Integer> map = new HashMap<>();
        char[] nums = {'0','1','2','3','4','5','6','7','8','9'};
        int number=0;
        for(char ch : nums) map.put(ch,number++);
        
        int tenPow_n1 = (int) Math.pow(10,n1-1);
        int tenPow_n2 = (int) Math.pow(10,n2-1);
        
        int numeric_num1=0, numeric_num2=0;
        
        for(int i=0;i<n1;i++){
            int val = map.get(num1.charAt(i));
            numeric_num1 += val * tenPow_n1;
            tenPow_n1 = tenPow_n1/10; 
        }
        
        for(int i=0;i<n2;i++){
            int val = map.get(num2.charAt(i));
            numeric_num2 += val * tenPow_n2;
            tenPow_n2 = tenPow_n2/10; 
        }
        
        return String.valueOf(numeric_num1+numeric_num2);
        
    }
}

// solution which can accept huge numbers(add using old shool method)
class AddInteger2 {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        if(n1 == 0 && n2 == 0) return "";
        if(n1 == 0) return num2;
        if(n2 == 0) return num1;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] nums = {'0','1','2','3','4','5','6','7','8','9'};
        int number=0;
        for(char ch : nums) map.put(ch,number++);
        StringBuilder sb = new StringBuilder("");
        int carry=0; n1=n1-1; n2=n2-1;
        while(n1>=0 || n2>=0){
            int v1 = n1 >= 0 ? map.get(num1.charAt(n1)) : 0 ;
            int v2 = n2 >= 0 ? map.get(num2.charAt(n2)) : 0 ;
            int add = v1+v2+carry;
            if(add>9){carry=1; add=add%10;}
            else carry=0;
            sb.append(add);
            n1--;n2--;
        }
        if(carry==1) sb.append(carry);
        return sb.reverse().toString();  
    }
}