package GRAPH;

//1) naive approach
//Naive Approach [Complexity -> O(N*number_of_trust_relationship)]
class Solution {
    
    boolean case1(int candidate, int[][] trust, int N){
        for(int i=0;i<trust.length;i++)
            if(trust[i][0] == candidate) return false;
        return true;
    }
    
    boolean case2(int candidate, int[][] trust, int N){
       int count[] = new int[N+1];
       for(int i=0;i<trust.length;i++)
            if(trust[i][1] == candidate) count[trust[i][0]]=1;
        
       for(int i=1;i<N+1;i++)
           if(count[i]==0 && i!=candidate) return false;
       return true;
    }
    
    public int findJudge(int N, int[][] trust) {
        int town_judge = -1,counter=0;
        for(int i=1; i<=N;i++){
            if(case1(i,trust,N) && case2(i,trust,N)){
                counter++;
                if(counter>1) return -1; //case3
                town_judge = i;
            }
        }
        
        return town_judge;        
    }
}

/**(2)
Time Complexity-> O(number_of_relationship)
Space Complexity-> O(N)
[using in-degree & out-degree]

 * class Solution {
    public int findJudge(int N, int[][] trust) {
        int size = trust.length;
        int in_degree[] = new int[N+1];
        int out_degree[] = new int[N+1];
        
        for(int i=0;i<size;i++){ 
            out_degree[trust[i][0]]++;  //out_degree
            in_degree[trust[i][1]]++;   //in_degree
        }
		 //check the required constrains
        int counter = 0, town_judge=-1;
        for(int i=1;i<=N;i++){
            if(in_degree[i] == N-1 && out_degree[i] == 0){
                counter++;
                if(counter>1) return -1;
                town_judge=i;
            }
        }
        return town_judge;
    }
}

 */