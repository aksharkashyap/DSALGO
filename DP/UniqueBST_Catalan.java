package DP;
//nth catlan number 
//for amazing applications : https://en.wikipedia.org/wiki/Catalan_number
// formula ->   2nCn/ n+1
public class UniqueBST_Catalan {
    //Recursive
    int solve_recursive(int n){
        int ans=0;
        if(n == 0 || n == 1) return 1;
        for(int i=1;i<=n;i++)
            ans += solve_recursive(i-1) * solve_recursive(n-i);
        return ans;
    }

    //DP
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = 0;
            for(int j=0;j<i;j++)
                dp[i] += dp[j] * dp[i-j-1];
        }
        return dp[n];
    }

}
/**In combinatorial mathematics, the Catalan numbers form a sequence of natural numbers that occur in various 
   counting problems, often involving recursively-defined objects. 
 * They are named after the Belgian mathematician Eugène Charles Catalan */

/** Applications--------------------------------------
 
1) Count the number of expressions containing n pairs of parentheses which are correctly matched. 
    For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).

2) Count the number of possible Binary Search Trees / or unlabeled tree with n keys (See this)

3) Count the number of full binary trees (A rooted binary tree is full if every vertex has 
   either two children or no children) with n+1 leaves.

4) Given a number n, return the number of ways you can draw n chords in a circle 
   with 2 x n points such that no 2 chords intersect.

https://www.youtube.com/watch?v=J0heuWnOKcw

4) polygon triangulation
5) hanshake across the table
6) number of ways to form a "mountain range" with n upstrokes and n downstrokes that all stay above a horizontal line
7) Cn−1 is the number of possible separation sequences which can separate a mixture of n components
8) Cn is the number of ways to tile a stairstep shape of height n with n rectangles
9) Cn is the number of noncrossing partitions of the set
10) A convex polygon with n + 2 sides can be cut into triangles by connecting vertices with non-crossing line segments (a form of polygon triangulation). 
The number of triangles formed is n and the number of different ways that this can be achieved is Cn
11) Cn is the number of non-isomorphic ordered trees with n + 1 vertices
12) Cn is the number of monotonic lattice paths along the edges of a grid with n × n square cells, which do not pass above the diagonal.
13) Cn is the number of Dyck words of length 2n
14) Cn is the number of semiorders on n unlabeled items
 */