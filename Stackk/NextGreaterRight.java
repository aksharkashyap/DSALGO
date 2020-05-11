package Stackk;
//next greater to right

import java.util.*;
public class NextGreaterRight {
    

   static void solve(int arr[],int n,List<Integer> list){
       Stack<Integer> s = new Stack<>();
       for(int i=n-1;i>=0;i++){

            if(s.isEmpty()){
                list.add(-1);
            }
            else if(s.size()>0 && s.peek() > arr[i]) list.add(s.peek());
            else if(s.size()>0 && s.peek() <=arr[i]){
                    while(s.size()>0 && s.peek()<=arr[i]) s.pop();
            
            if(s.size() ==0)list.add(-1);
            else list.add(s.peek());
            }
            s.push(arr[i]);
       }
   }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int [] arr = {2,7,9,6,8,9,67};
        solve(arr,arr.length,list);
        Collections.reverse(list);
        System.out.println(list);
    }
}