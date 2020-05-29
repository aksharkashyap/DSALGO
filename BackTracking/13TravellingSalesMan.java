package BackTracking;
/* its a NP-Hard problem
Given a set of cities and distance between every pair of cities, the problem is to find the shortest 
possible route that visits every city exactly once and returns to the starting point
*/

/*naive approach
->O(n!)
-> generate all possible permutations -> all possble hamiltonian cycles
-> keep track of the lowest costing route
*/

/**implimentations
 * 1) backtracking (n!)
 * 2) dynamic programming ( n^2 * 2^n) ( not feasible when vertices are in huge amount because of the storage issue)
 * 3) using MST approximation
 * 4) using genetic algorithm 
 * 
 */
class TravellingSalesMan {
    
}