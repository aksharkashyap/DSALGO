package Stackk;

class $_6_RainWaterTrapping  {

    static void solve(int arr[], int n){
        int maxL[] = new int[n];
        int maxR[] = new int[n];
        maxL[0] = arr[0];
        maxR[n-1] = arr[n-1];

        for(int i=1;i<n;i++){   //maxL
            maxL[i] = (arr[i] > maxL[i-1]) ? arr[i] : maxL[i-1];
        }

        for(int j=n-2;j>=0;j--){    //maxR
            maxR[j] = (arr[j] > maxR[j+1]) ? arr[j] : maxR[j+1];
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans += Math.min(maxL[i],maxR[i]) - arr[i];
        }
        System.out.println(ans);
    }
    
    

    public static void main(String[] args) {
        int arr[]={3,0,2,0,4};
        int n = arr.length;
        solve(arr,n);
    }
}