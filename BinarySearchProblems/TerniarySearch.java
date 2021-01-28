package BinarySearchProblems;

//log(base3)n
class TerniarySearch{

    static int search(int start, int end, int arr[], int key){

        while(start<=end){
            int mid1 = start + (end-start)/2;
            int mid2 = end + (end-start)/2;
            if(arr[mid1] == key) return mid1;
            if(arr[mid2] == key) return mid2;
            
            if(key < arr[mid1]) end = mid1-1; // key lies b/w [start to mid1]
            else if(key > arr[mid2])  start = mid2+1; //key lies b/w [mid2 to end]
            else{ //key lies b/w [mid1 to mid2]
                start = mid1+1;
                end = mid2-1;
            }
        }

        return -1;
    }

}