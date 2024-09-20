package TopologicalSorting;

import java.util.*;

class AlienDictionary {
    public static String alienOrder(List<String> words) {
        List<Character> result = new ArrayList<>();
        String s = "";
        List<List<Character>> input = new ArrayList<>();
        HashMap<Character,Integer> freq = new HashMap<>();
        HashMap<Character,List<Character>> dep = new HashMap<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        int n = words.size();
        for(String word : words){
            for(char c: word.toCharArray()){
                freq.putIfAbsent(c,0);
                freq.putIfAbsent(c,0);
                dep.putIfAbsent(c, new ArrayList<>());
                dep.putIfAbsent(c, new ArrayList<>());
            }
        }
        for(int i = 0 ; i <n-1 ; i++){
            String s1 = words.get(i);
            String s2 = words.get(i+1);
            int a = 0;
            int b = 0;
            while(a<s1.length() && b<s2.length()){
                if(s1.charAt(a) == s2.charAt(b)){
                    a++;
                    b++;
                }else{
                    input.add(Arrays.asList(s2.charAt(b),s1.charAt(a)));
                    break;
                }
            }
            if((b == s2.length()) && (a< s1.length()) ) return s;
        }
        System.out.println(input.toString());


        for(List<Character> c: input){
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
        for(char c : result){
            s= s.concat(String.valueOf(c));
        }

        return s ;

    }

    public static void main(String args[]) {
        List<List<String>> words = Arrays.asList(
                Arrays.asList("mzosr", "mqov", "xxsvq", "xazv", "xazau", "xaqu", "suvzu", "suvxq", "suam", "suax", "rom", "rwx", "rwv"),
                Arrays.asList("vanilla", "alpine", "algor", "port", "norm", "nylon", "ophellia", "hidden"),
                Arrays.asList("passengers", "to", "the", "unknown"),
                Arrays.asList("alpha", "bravo", "charlie", "delta"),
                Arrays.asList("jupyter", "ascending")
        );

        for (int i = 0; i < words.size(); i++) {
            System.out.println(i + 1 + ".\twords = " + words.get(i));
            alienOrder(words.get(i));
            System.out.println("\tDictionary = \"" + alienOrder(words.get(i)) + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}