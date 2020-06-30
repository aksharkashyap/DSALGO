import java.util.Arrays;

class Test{

    static void swap(int arr[],int i, int j){
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
    static int getPivot(int arr[], int l, int r){
        int pos=l;
        int pivot = r;

        for(int i=l;i<pivot;i++)//find pivot pos
            if(arr[i]<=arr[pivot]) swap(arr,pos++,i);
        
        swap(arr,pivot,pos); // place the pivot at correct position
        return pos;
    }

    static void sort(int arr[],int l, int r){
        if(l>=r) return;
        int mid = getPivot(arr,l,r);
        sort(arr,l,mid-1);
        sort(arr,mid+1,r);
    }

    public static void main(String[] args) {
        int arr[] = {2,3,49,13,12,5,3,5,55,2,3,5,7,2,11,5};
        sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
