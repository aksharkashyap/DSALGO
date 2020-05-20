import java.util.Arrays;
//insert in a max heapify order
class Test{
    int TOP = -1;
    int HEAP[];
    int parent(int i){
        return (i-1)/2;
    }
    Test(int n){
        HEAP = new int[n];
    }
    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }

    void solve(int n){
        HEAP[++TOP] = n;
        int curr = TOP;
        while(HEAP[curr] > HEAP[parent(curr)]){
            swap(HEAP,curr,parent(curr));
            curr = parent(curr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,31,3,4,5,6,5,1};
        Test ob = new Test(arr.length);
        System.out.print(Arrays.toString(arr));
        for(int i : arr) ob.solve(i);
        System.out.print(Arrays.toString(ob.HEAP));
    }
}