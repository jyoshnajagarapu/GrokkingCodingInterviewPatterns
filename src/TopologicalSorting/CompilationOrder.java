//solvedbyme
package TopologicalSorting;
import java.util.*;

class CompilationOrder {

    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies){
        List<Character> result = new ArrayList<>();
        HashMap<Character,Integer> freq = new HashMap<>();
        HashMap<Character,List<Character>> dep = new HashMap<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for(ArrayList<Character> c : dependencies){
            dep.putIfAbsent(c.get(0), new ArrayList<>());
            dep.putIfAbsent(c.get(1), new ArrayList<>());
            freq.putIfAbsent(c.get(0),0);
            freq.putIfAbsent(c.get(1),0);
        }

        for(ArrayList<Character> c: dependencies){
            dep.get(c.get(1)).add(c.get(0));
            freq.put(c.get(0) , freq.get(c.get(0))+1);
        }

        for(Map.Entry<Character,Integer> a: freq.entrySet()){
            if(a.getValue() == 0 ) {
                queue.add(a.getKey());
            }
        }

        while(!queue.isEmpty()){
            char ele = queue.poll();
            if(!result.contains(ele)){
                result.add(ele);
                for(Character c: dep.get(ele)){
                    freq.put(c , freq.get(c)-1);
                    if(freq.get(c) == 0 ) queue.add(c);
                }
            }
        }

        return result ;



    }
    public static void main( String args[] ) {
        ArrayList<ArrayList<ArrayList<Character>>> dependencies = new ArrayList<ArrayList<ArrayList<Character>>>() {
            {
                add(new ArrayList<ArrayList<Character>>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('B', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('C', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('D', 'C')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'D')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'B')));
                    }
                });
                add(new ArrayList<ArrayList<Character>>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('B', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('C', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('D', 'B')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'B')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'D')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'C')));
                        add(new ArrayList<Character>(Arrays.asList('F', 'D')));
                        add(new ArrayList<Character>(Arrays.asList('F', 'E')));
                        add(new ArrayList<Character>(Arrays.asList('F', 'C')));
                    }
                });
                add(new ArrayList<ArrayList<Character>>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('A', 'B')));
                        add(new ArrayList<Character>(Arrays.asList('B', 'A')));
                    }
                });
                add(new ArrayList<ArrayList<Character>>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('B', 'C')));
                        add(new ArrayList<Character>(Arrays.asList('C', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('A', 'F')));
                    }
                });
                add(new ArrayList<ArrayList<Character>>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('C', 'C')));
                    }
                });
            }
        };
        for(int i = 0; i < dependencies.size(); i++){
            System.out.println(i + 1 + ".\tdependencies: " + dependencies.get(i));
            System.out.println("\tCompilation Order: " + findCompilationOrder(dependencies.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}