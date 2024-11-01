package Graph;

// Java program for the above approach

import java.util.*;

 class Main {
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


    // Function to solve the problem
    static int minCostToProvideWater(int n, int[] wells, int[][] pipes) {
         parent = new int[n+1];
         rank  =new int[n+1];
         int res = 0 ;
         int[][] newpipe = Arrays.copyOf(pipes,pipes.length + n);
         int i = pipes.length;
         for(int j = 0 ; j< wells.length; j++){
             newpipe[i++] = new int[]{0,j+1,wells[j]};
         }
        for(int k = 0; k <= n ; k++){
            parent[k] = k ;
            rank[k] = k;
        }
        Arrays.sort(newpipe, Comparator.comparingInt(a -> a[2]));
        for(int[] a : newpipe) {
            if (connect(a[0], a[1])) {
                res += a[2];
            }
        }

         return res ;
    }

    // Driver Function
    public static void main(String[] args) {
        int N = 3;
        int[] wells = new int[]{1, 2, 2};
        int[][] pipes = new int[][]{{1, 2, 1},{2, 3, 1}};

        // Function call
        System.out.println(minCostToProvideWater(N, wells, pipes));
    }
}

//https://leetcode.com/problems/optimize-water-distribution-in-a-village/

//class Solution {
//    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
//        UnionFind uf = new UnionFind(n);
//        int res = 0 ;
//        int[][] newpipe = Arrays.copyOf(pipes,pipes.length + n);
//        int i = pipes.length;
//        for(int j = 0 ; j< wells.length; j++){
//            newpipe[i++] = new int[]{0,j+1,wells[j]};
//        }
//        Arrays.sort(newpipe, Comparator.comparingInt(a -> a[2]));
//        for(int[] a : newpipe) {
//            if (uf.connect(a[0], a[1])) {
//                res += a[2];
//            }
//        }
//        return res ;
//
//    }
//}
//
//class UnionFind{
//    int parent[];
//    int rank[];
//    UnionFind(int n){
//        parent = new int[n+1];
//        rank = new int[n+1];
//        for(int i = 0; i <= n ; i++){
//            parent[i] = i ;
//            rank[i] = 1;
//        }
//    }
//    boolean connect(int v1, int v2){
//        int p1 = find(v1);
//        int p2 = find(v2);
//        if(p1 == p2) return false;
//        if(rank[p1] >= rank[p2]){
//            parent[p2] = p1;
//            rank[p1] += rank[p2];
//        } else{
//            parent[p1] = p2;
//            rank[p2] +=rank[p1];
//        }
//        return true;
//    }
//
//    int find(int p1){
//        if(parent[p1] != p1){
//            parent[p1] = find(parent[p1]);
//        }
//        return parent[p1];
//    }
//}
