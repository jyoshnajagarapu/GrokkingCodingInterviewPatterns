package Graph;

import java.util.*;

class Solution3 {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        ArrayDeque<int[]> q = new ArrayDeque<>();
        List<Integer> visited = new ArrayList<>();
        int buses = 0;
        for(int i = 0 ; i < routes.length ; i++){
            int[] stations = routes[i];
            for(int a : stations){
                map.computeIfAbsent(a, (l) -> new ArrayList<>()).add(i);
            }
        }
        System.out.println("map" + map);

        // for(int bus : map.get(source)){
        //     int[] stations = routes.get(bus);
        //     for(int st : stations){
        //         q.add(st,buses);
        //     }
        // }
        // visited.add(source);
        q.add(new int[]{source,0});

        while(!q.isEmpty()){
            int[] st = q.poll();
            buses = st[1];
            if(st[0] == target) return buses;
            if(!visited.contains(st[0])){
                visited.add(st[0]);
                for(int bus : map.get(st[0])){
                    int[] stations = routes[bus];
                    for(int t : stations){
                        if(!visited.contains(t)) q.add(new int[] {t,buses+1});

                    }
                }
            }
        }

        return -1;


    }
    public static void main(String[] args) {
        int[][][] routes = {
                {{2, 5, 7}, {4, 6, 7}},
                {{1, 12}, {4, 5, 9}, {9, 19}, {10, 12, 13}},
                {{1, 12}, {10, 5, 9}, {4, 19}, {10, 12, 13}},
                {{1, 9, 7, 8}, {3, 6, 7}, {4, 9}, {8, 2, 3, 7}, {2, 4, 5}},
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        };
        int[] src = {2, 9, 1, 1, 4};
        int[] dest = {6, 12, 9, 5, 6};

        for (int i = 0; i < routes.length; i++) {
            System.out.print((i + 1) + ".\tBus Routes: ");
            System.out.print(Arrays.deepToString(routes[i]));
            System.out.println();
            System.out.println("\tSource: " + src[i]);
            System.out.println("\tDestination: " + dest[i]);
            System.out.println("\n\tMinimum Buses Required: " + numBusesToDestination(routes[i], src[i], dest[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}