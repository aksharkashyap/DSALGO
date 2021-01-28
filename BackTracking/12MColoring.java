package BackTracking;

import java.util.*;

/** much better than backtracking
 * https://leetcode.com/problems/is-graph-bipartite/
 * https://youtu.be/FofydiwP5YQ
 */
class MColoring12 {
   
    
    public boolean isBipartite(int[][] graph) {
         int[] color = new int[graph.length];
         Arrays.fill(color, -1);
         for (int i = 0; i < graph.length; i++)
             if ((color[i] == -1) && !bfs(i, graph, color))
                 return false;
         return true;
     }
     
     private boolean bfs(int node, int[][] graph, int[] color) {
         Queue<Integer> q = new LinkedList<>();
         q.add(node);
         color[node] = 0;
         while (!q.isEmpty()) {
             int curr = q.poll();
             for (int nei : graph[curr]) {
                 if (color[nei] == color[curr])
                     return false;
                 if (color[nei] == -1) {
                     color[nei] = 1 - color[curr];
                     q.add(nei);
                 }
             }
         }
         return true;
     }
     
}