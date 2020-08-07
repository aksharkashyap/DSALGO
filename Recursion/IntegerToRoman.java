package Recursion;

class ItoR {

    final static String[] ONES = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    final static String[] TENS = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    final static String[] HUNDREDS = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    final static String[] THOUSANDS = {"","M","MM","MMM"};
    
    public String intToRoman(int num) {
        int place = 1;
        String ans="";
        while(num>0){
            int rem = num % 10;
            rem *= place;
            ans = helper(rem) + ans;
            place*= 10;
            num = num / 10;  
        }
        return ans;
    }
    
    String helper(int num){
        if(num < 10) return ONES[num];
        else if(num<100) return TENS[num/10];
        else if(num<1000) return HUNDREDS[num/100];
        else return THOUSANDS[num/1000];
    }
}
//reference video
//https://www.youtube.com/watch?v=Gw-GNey94j8