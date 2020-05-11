package Java;
class InsertionSortPrac
{

    static int[] sort(int arr[],int n)
    {
        int pos=0;
        int value =0;
        for(int i=1;i<n;i++)
        {
            pos=i;
            value=arr[i];
            while(pos>0 && arr[pos-1] > value)
            {

                arr[pos] = arr[pos-1];
                pos = pos-1;
            }
            arr[pos] = value;
        }
        return arr;

    }

    public static void main(String args[])
    {
        int arr[] = {10,2,4,11,5};
        int getarr[]=sort(arr,arr.length);
        for(int i=0;i<getarr.length;i++)
        {
            System.out.print(getarr[i]+" ");
        }
    }
}