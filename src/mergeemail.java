import java.util.*;

class Solution3 {
    int[] parent;
    int[] rank;
    HashMap<String , Integer> map = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        int n = accounts.size();
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            rank[i] =1;
        }
        for( int i = 0 ; i < n;i++ ){
            List<String> email = accounts.get(i);
            for(int j = 1; j< email.size();j++){
                if(map.containsKey(email.get(j))){
                    if(accounts.get(i).get(0) != accounts.get(map.get(email.get(j))).get(0)){
                        return new ArrayList<>();
                    }
                    connection(map.get(email.get(j)),i);
                }
                map.put(email.get(j),i);
            }
        }
        System.out.println("map" + map);
        HashMap<Integer,List<String>> map1 = new HashMap<>();
        for(Map.Entry<String,Integer> temp : map.entrySet()){
            System.out.println("value" + temp.getValue());
            map1.computeIfAbsent(temp.getValue(), k -> new ArrayList<>()).add(temp.getKey());
        }
        System.out.println("map1" + map1);

        for(Map.Entry<Integer,List<String>> temp : map1.entrySet()){
            int key = temp.getKey();
            List<String> emails = temp.getValue();
            List<String> account = new ArrayList<>();
            account.add(accounts.get(key).get(0));
            Collections.sort(emails);
            account.addAll(emails);
            result.add(account);
        }

        return result;

    }
    public void connection(int v1 , int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        parent[p2] = p1;
        return ;
    }

    public int find(int p1){
        if(p1!= parent[p1]){
            parent[p1] = find(parent[p1]);
        }
        return parent[p1];
    }
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
                Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
                Arrays.asList("Mary","mary@mail.com"),
                Arrays.asList("John","johnnybravo@mail.com"));
        s.accountsMerge(accounts);
    }


}