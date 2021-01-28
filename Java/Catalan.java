package Java;

class Catalan{

    static int catalan(int n)
    {
        int catalanDp[] = new int[n+2];
        catalanDp[0]=catalanDp[1]=1;

        for(int i=2;i<=n;i++){
            catalanDp[i]=0;
            for(int j=0;j<i;j++)
                catalanDp[i] += catalanDp[j] * catalanDp[i-j-1];
        }

        return catalanDp[n];

    }


    public static void main(String args[]){
        for(int i=0;i<10;i++)
            System.out.print(catalan(i)+" ");
    }
}