package BackTracking;

// traverse the vertices exactly once and get back to the starting vertex

class HamiltonianCycle {
    StringBuilder str = new StringBuilder("");

    boolean verify(boolean[]visited, int[][]graph){
        for(int i=0;i<visited.length;i++)
            if(!visited[i]) return false;

        char x = str.charAt(str.length()-1);
        int c = Integer.parseInt(Character.toString(x));
        if(graph[c][0] == 1) return true;
        
        return false;
    }

    boolean solve(int[][]graph, boolean[]visited, int V, int N){
        
        for(int i=0;i < N;i++){
            if(graph[V][i] == 1 && !visited[i]){
                visited[i] = true;
                str.append(i);
                if(solve(graph, visited, i, N)) return true;
                visited[i] = false;
                str.setLength(str.length()-1);
                
            }
        }
        return verify(visited,graph);
    }

    void h_cycle(int[][]graph, int N){
        boolean visited[] = new boolean[N];
        int start = 0;
        
        visited[start] = true;
        str.append(start);
        if(solve(graph, visited,start,N))System.out.println("Hamiltonian path exist");
        else{
            System.out.println("Hamiltonian path doesnt exist");
            str.setLength(str.length()-1);
        }
    }
    public static void main(String[] args) {
        HamiltonianCycle obj = new HamiltonianCycle();
        int graph2[][] = {{0, 1, 0, 1, 0}, 
            {1, 0, 1, 1, 1}, 
            {0, 1, 0, 0, 1}, 
            {1, 1, 0, 0, 1}, 
            {0, 1, 1, 1, 0}, 
            };
        obj.h_cycle(graph2,graph2.length);
        System.out.println(obj.str);
    }
}