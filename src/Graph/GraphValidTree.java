package Graph;

import java.util.*;

 class Solution {
    public static boolean validTree(int n, int[][] edges) {
//        List<List<Integer>> list = new ArrayList<>();
//        for(int i=0; i<n; i++){
//            list.add(new ArrayList<>());
//        }
//        for(int[] edge : edges){
//            list.get(edge[0]).add(edge[1]);
//            list.get(edge[1]).add(edge[0]);
//        }
//        boolean[] visited = new boolean[n];
//        Queue<Integer> queue = new LinkedList<>();
//        Queue<Integer> queue1 = new LinkedList<>();
//        queue.offer(0);
//        while(!queue.isEmpty()){
//            int id = queue.poll();
////            if(visited[id]){
////                return false;
////            }
//            if(!visited[id]){
//                queue1.add(id);
//            }
//
//            visited[id] = true;
//
//            for(int neighbor : list.get(id)){
//                if(!visited[neighbor]){
//                    queue.offer(neighbor);
//                }
//            }
//        }
//
//        System.out.println( queue1);
//        for(boolean b : visited){
//            if(!b) return false;
//        }
//        return true;

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for(int[] edge : edges){
            map.computeIfAbsent(edge[0] , (l) -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1] , (l) -> new ArrayList<>()).add(edge[0]);
        }
        q.add(0);
        while(!q.isEmpty()){
            int val = q.poll();
            if(result.contains(val)) return false;
            result.add(val);
            for(int b : map.get(val)){
                if(!result.contains(b)) q.add(b);
            }
        }

        return true;





    }

    // Driver code
    public static void main(String[] args) {
        int[] n = {3, 4, 5, 5, 6};
        int[][][] edges = {
                {{0, 1}, {0, 2}, {1, 2}},
                {{0, 1}, {0, 2}, {0, 3}},
                {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {3, 4}},
                {{0, 1}, {0, 2}, {0, 3}, {3, 4}},
                {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {0, 5}}
        };

        for (int i = 0; i < n.length; i++) {
            System.out.println((i + 1) + ". n = " + n[i]);
            System.out.println("   Edges = " + Arrays.deepToString(edges[i]));
            System.out.println("   Is the given graph a valid tree: " + validTree(n[i], edges[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}