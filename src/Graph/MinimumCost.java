package Graph;

import java.util.Arrays;

public class MinimumCost {
    // Function to calculate the minimum cost of connections
    static int parent[];
    static int rank[];
    static boolean connect(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 == p2) return false;
        if(rank[p1] >= rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else{
            parent[p1] = p2;
            rank[p2] +=rank[p1];
        }
        return true;
    }

    static int find(int p1){
        if(parent[p1] != p1){
            parent[p1] = find(parent[p1]);
        }
        return parent[p1];
    }
    static int calculateMinimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a,b) -> a[2] - b[2]);
        parent = new int[n+1];
        rank = new int[n+1];
        int res = 0 ;
        int components = n ;
        for(int i = 1; i <= n ; i++){
            parent[i] = i ;
            rank[i] = 1;
        }
        for(int[] a : connections){
            if(connect(a[0], a[1])){
                res+=a[2];
                components--;
            }
        }
        System.out.println("res" +  res);
        if(components != 1) return -1;
        return res;
    }


    // Driver code
    public static void main(String[] args) {
        // Define the number of nodes and connections
        int n = 3;
        int[][] connections = { { 1, 2, 5 }, { 1, 3, 6 }, { 2, 3, 1 } };

        // Calculate the minimum cost
        int minCost = calculateMinimumCost(n, connections);

        // Print the minimum cost
        System.out.println("The minimum cost is: " + minCost);
    }
}
