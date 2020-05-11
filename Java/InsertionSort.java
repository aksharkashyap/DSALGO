package Java;
class InsertionSort{

    static int[] insertion_sort(int arr[],int size)
    {
         int pos=0;
         int value=0;
         for(int i =1; i<size; i++)
         {
            value = arr[i];
            pos = i;
            while(pos>0 && arr[pos-1] >value)
            {
                arr[pos] = arr[pos-1];
                pos = pos-1;
            }
            arr[pos] = value;
         }
         return arr;
    }
    public static void main(String args[]){
        int arr[] = {10,40,12,45,22,53,11};
        int get[] = insertion_sort(arr,arr.length);
        for(int i=0;i<get.length;i++)
            System.out.print(get[i]+" ");

    }
}