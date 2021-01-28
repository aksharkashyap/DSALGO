package TCS;
import java.util.*;

class Election {

     static String solve(String s, int n){
        char[] str = s.toCharArray();
        int right=0,a=0,b=0,i=0;

        for(int k=0;k<n;k++){
            if(str[k] == 'A') a++;
            else if(str[k] == 'B') b++;
        }

        if(str[0] == '-' ){
            while(!Character.isLetter(str[i])) i++;
            right = i;
            if(str[i] == 'A') a += right-1;
        }
        int left=i;

        while(i<n-1){
           while(i+1 < n && Character.isLetter(str[i+1])) i++;
           left = i;
           while(i+1 < n && !Character.isLetter(str[i+1])) i++;
           right = i+1;
           
           int len  = right - left + 1;
           if(str[left]=='B' && (right==n || str[right]=='B')){
               b += len-2;
           }
           else if(str[left]=='A' && (right==n || str[right]=='A')){
            a += len-2;
           }
           else if(str[left] == 'B' && str[right] == 'A'){
                int chunk = (len)/2;
                a += chunk-1;
                b += chunk-1;
            }
        }
        if(a>b) return "A";
        if(a<b) return "B";
        return "Coalition government";
    }
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       // int len = sc.nextInt();
        String str = "--AAA--BA--ABA--A--";
        System.out.print(solve(str,str.length()));
        sc.close();
    }
}