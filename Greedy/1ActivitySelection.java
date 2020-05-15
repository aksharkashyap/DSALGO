
package Greedy;

/**
 * Time Complexity : It takes O(n log n) time if input activities may not be sorted. 
 * It takes O(n) time when it is given that input activities are always sorted
 * note that -> sorting the activity acc to finish time will always ensure that we will get optimal ans by choosing 1st sorted activity
 */
import java.util.Arrays;

class ActivitySelection{

    static void activity_selection_greedy(int start,int[]startA,int[]finish,int n){
        int count=1;
            for(int j=start+1;j<n;j++){
                if(startA[j] >= finish[start]){
                    start = j;
                    count++;
                }
            }
        System.out.println("Max activity can be performed: "+count);
    }

    public static void main(String[] args) {
        
        int start_given[] =  {5, 8, 5,1, 3,0};
        int finish_given[] =  {7, 9, 9,2, 4, 6}; 
        int n = start_given.length;

        //step 1 -> sort it acc to finish time for greedy
       /* for(int i=0;i<n-1;i++){ //n-1 passes
            for(int j=0;j<n-i-1;j++){
                if(finish_given[j] > finish_given[j+1]){
                    int temp = finish_given[j];
                    finish_given[j] = finish_given[j+1];
                    finish_given[j+1] = temp;

                    temp = start_given[j];
                    start_given[j] = start_given[j+1];
                    start_given[j+1] = temp;
                }
            }
        }*/
        activity_selection_greedy(0,start_given,finish_given,n);
    }
}