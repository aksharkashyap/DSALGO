import java.util.Arrays;
import java.util.Stack;

class Histogram{
   
    static class pair{
        int first,second;
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
  
    static int[] NSL(int arr[], int n){ //nearest smaller to left
        Stack<pair> stack = new Stack<>(); 
        int[] idx_nsl = new int[n];
        for(int i=0;i<n;i++){
            if(stack.size() == 0){
                idx_nsl[i] = -1;
            }else{
                while(stack.size()>0 && stack.peek().second > arr[i]) stack.pop();
                if(stack.size() == 0) idx_nsl[i] = -1;
                else idx_nsl[i]  = stack.peek().first;
            }
            stack.push(new pair(i,arr[i]));
        }
        return idx_nsl;
    }

    static int[] NSR(int arr[], int n){ //next smaller to right
        Stack<pair> stack = new Stack<>(); 
        int[] idx_nsr = new int[n];
        for(int i=n-1;i>=0;i--){
            if(stack.size() == 0){
                idx_nsr[i] = n;
            }else{
                while(stack.size()>0 && stack.peek().second > arr[i]) stack.pop();
                if(stack.size() == 0) idx_nsr[i] = n;
                else idx_nsr[i]  = stack.peek().first;
            }
            stack.push(new pair(i,arr[i]));
        }
        return idx_nsr;
    }

    static void solve_stack(int arr[], int n){
        int[] a = NSR(arr, n);
        int[] b = NSL(arr, n);
        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = (a[i] - b[i] -1) * arr[i];
        }

       // System.out.println(Arrays.toString(a));
       // System.out.println(Arrays.toString(b));
       // System.out.println(Arrays.toString(ans));
        int max=0;
        for(int i=0;i<n;i++)
            max = Math.max(ans[i],max);
        System.out.print(max);

    }

    public static void main(String[] args) {
        int arr[]={6,2,5,4,5,1,6};
        solve_stack(arr, arr.length);
        
    }
}


