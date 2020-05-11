package Java;

// count the occurance of a key in avg - O(logn) time

class OccuranceNum{

    public static int sol(int arr[],int start, int end,int key){
            int count =0;

            if(end>=start){
                
                int mid = start + (end-start)/2;
                if(arr[mid] == key)
                {
                    count++;
                    int m1 = mid, m2 = mid;
                    while(m1+1 <arr.length && key == arr[m1+1]) // move to the left
                    {
                        count++;
                        m1++;
                    }

                    while(m2-1 >=0 && key == arr[m2-1]) // move to the right
                    {
                        count++;
                        m2--;
                    }
                    
                    return count;
                }
                
                if(arr[mid] > key)
                    return sol(arr,start,mid-1,key);
                
                else 
                    return sol(arr,mid+1,end,key);
            }
            return -1;
    }

    public static void main(String args[]){
        int arr[] = {1,2,2,2,3,3};
        int key = 3;
        int start = 0;
        int end = arr.length-1;
        int x = sol(arr,start,end,key);
        System.out.println("count: "+ x);
    }

}