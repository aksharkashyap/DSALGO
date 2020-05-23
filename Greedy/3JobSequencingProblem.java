package Greedy;

import java.util.Arrays;
import java.util.Comparator;

class JobSequencing{

    static class Job{
        int id,profit,deadline;
        Job(int id, int profit, int deadline){
            this.id=id;
            this.profit=profit;
            this.deadline=deadline;
        }
    }

    public static class Sort implements Comparator<Job>{
        public int compare(Job a, Job b) {
            return b.profit - a.profit;
        }
    }

    static void solve(Job[] job_arr, int n){
        boolean slot[] = new boolean[n];
        int result[] = new int[n];

        for(int i=0;i<n;i++){ //pick jobs 1 by 1

            for(int j=Math.min(n,job_arr[i].deadline)-1;j>=0;j--){
                if(!slot[j]){
                    slot[j] = true;
                    result[j] = i;
                    break;
                }
            }
        }
        System.out.println("max profit job sequence: ");
        for (int i=0; i<n; i++) 
            if (slot[i]) 
                System.out.print(job_arr[result[i]].id + " "); 
    }

    public static void main(String[] args) {
        Job job_arr[] = new Job[4];
        job_arr[0] = new Job(1,50,2);
        job_arr[1] = new Job(2,15,1);
        job_arr[2] = new Job(3,10,2);
        job_arr[3] = new Job(4,25,1);
        //sort by decreasing order of profit
        Arrays.sort(job_arr, new Sort());
        solve(job_arr, job_arr.length);
       
    }
}
/**
 * Given an array of jobs where every job has a deadline and associated profit if the job is 
 * finished before the deadline. It is also given that every job takes single unit of time, 
 * so the minimum possible deadline for any job is 1. 
 * How to maximize total profit if only one job can be scheduled at a time.
 */