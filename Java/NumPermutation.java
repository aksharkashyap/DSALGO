package Java;

class NumPermutation{

    static int count(int n){
        int c=0;
        while(n>0){
            n = n/10;
            c++;
        }
        return c;
    }

     static void permute(int N){
        int num = N;
        //int n = String.valueOf(N).length();
        int n = count(N);
        while(true){
            System.out.println(num);
            int rem = num % 10;
            int div = num / 10;
            num = (int)(Math.pow(10,n-1) * rem) +div;

            if(num == N)
                break;
        }
    }
    public static void main(String args[]){
        permute(1254);
    }
}