package TopologicalSorting;

import java.util.*;

class Solution {
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        //     // Construct directed graph and count in-degrees.
        //     Map<String, Set<String>> ingredientToRecipes = new HashMap<>();
        //     Map<String, Integer> inDegree = new HashMap<>();
        //     for (int i = 0; i < recipes.length; ++i) {
        //         for (String ing : ingredients.get(i)) {
        //             ingredientToRecipes.computeIfAbsent(ing, s -> new HashSet<>()).add(recipes[i]);
        //         }
        //         inDegree.put(recipes[i], ingredients.get(i).size());
        //     }
        //     // Toplogical Sort.
        //     List<String> ans = new ArrayList<>();
        //     Queue<String> available = Stream.of(supplies).collect(Collectors.toCollection(LinkedList::new));
        //     while (!available.isEmpty()) {
        //         String ing = available.poll();
        //         if (ingredientToRecipes.containsKey(ing)) {
        //             for (String rcp : ingredientToRecipes.remove(ing)) {
        //                 if (inDegree.merge(rcp, -1, Integer::sum) == 0) {
        //                     available.offer(rcp);
        //                     ans.add(rcp);
        //                 }
        //             }
        //         }
        //     }
        //     return ans;
        // }

        HashMap<String, List<String>> dep  = new HashMap<>();
        HashMap<String,Integer> freq = new HashMap<>();
        ArrayDeque<String> q = new ArrayDeque<>();
        List<String> result = new ArrayList<>();

        for(String r : recipes){
            freq.put(r,0);
        }

        int n = ingredients.size();
        for(int i = 0 ; i <n ; i++){
            List<String> ing = ingredients.get(i);
            for(String a: ing){
                dep.computeIfAbsent( a , (k)->new ArrayList<>()).add(recipes[i]);
            }
            freq.put(recipes[i],freq.get(recipes[i])+ing.size());
        }

        for(String s : supplies){
            if(dep.containsKey(s)){
                for(String a:dep.get(s)){
                    freq.put(a,freq.get(a)-1);
                    if(freq.get(a) == 0) q.add(a);

                }
            }

        }

        while(!q.isEmpty()){
            String s = q.poll();
            if(!result.contains(s)){
                result.add(s);
                if(dep.containsKey(s)){
                    for(String b : dep.get(s)){
                        freq.put(b,freq.get(b)-1);
                        if(freq.get(b) == 0) q.add(b);
                    }
                }

            }
        }
        System.out.println(result);
        return result;


    }

    public static void main(String args[]) {
        List<List<String>> words = Arrays.asList(
                Arrays.asList("yeast","flour"));
        String[] recipes = new String[]{"bread"};
        String[] supplies = new String[]{"yeast","flour","corn"};
        List<String> rec = findAllRecipes(recipes,words,supplies);

    }
}