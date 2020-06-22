package BinarySearchProblems;

public class UpperBound {
    //return the 1st large element than key
    int binarySearch_upperbound(int words[],int start, int end, int key){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(words[mid] > key) end = mid-1;
            else start = mid+1;
        }
        return start;
    }
}