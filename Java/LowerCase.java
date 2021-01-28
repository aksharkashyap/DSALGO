package Java;

class Solution {
    
    public static boolean check_case(char c)
    {
        if(c >= 'a' && c<= 'z')
            return true;
        return false;
    }
    
    public static char change_case(int c)
    {   char ch = (char) (c + 32);
        return ch;
    }
    
    public static String toLowerCase(String str) {
        
        StringBuilder s = new StringBuilder();
        
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(check_case(c)) // lowercase true
               {
                   s.append(c);
               }
             else
               {
                   //change the case
                 int ch = (int) c;
                   char changed = change_case(ch);
                   s.append(changed);
               }
        }
          return s.toString();
    }

    public static void main(String args[])
    {
       System.out.print(toLowerCase("Akshar"));
    }
             
    
    
}