package Graph;

import java.util.*;

 class PathsInMaze {
    public static int numberOfPaths(int n, int[][] corridors) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int result = 0;
        for(int[] cor : corridors){
            map.computeIfAbsent(cor[0] , (l) -> new ArrayList<>()).add(cor[1]);
            map.computeIfAbsent(cor[1], (l) -> new ArrayList<>()).add(cor[0]);
            if(intersection(map.get(cor[0]),map.get(cor[1]))) result++;
        }
        return result;
    }

     private static boolean intersection(List<Integer> integers, List<Integer> integers1) {
        for(int a: integers1){
            if(integers.contains(a)) return true;
        }
        return false;
     }


     // Driver code
    public static void main(String[] args) {
        int[] nList = {5, 4, 5, 5, 4};
        int[][][] corridorsList = {
                {{1, 2}, {5, 2}, {4, 1}, {2, 4}, {3, 1}, {3, 4}},
                {{1, 2}, {3, 4}},
                {{1, 2}, {5, 2}, {4, 1}, {3, 1}, {3, 4}},
                {{1, 2}, {5, 2}, {4, 1}, {2, 4}, {3, 1}, {3, 4}, {1, 5}},
                {{1, 2}, {2, 3}, {3, 4}}
        };

        for (int i = 0; i < nList.length; i++) {
            System.out.println((i + 1) + ".\t n: " + nList[i]);
            System.out.println("\t corridors: " + Arrays.deepToString(corridorsList[i]));
            System.out.println("\t cycles: " + numberOfPaths(nList[i], corridorsList[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}