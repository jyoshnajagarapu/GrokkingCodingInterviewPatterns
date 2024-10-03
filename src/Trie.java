import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

class Trie{
    boolean end ;
    Trie[] child;

    Trie(){
        this.end = false;
        child = new Trie[26];
    }

    void insert(String word){
        if(word.isEmpty()) return ;
        Trie temp = this;
        for(char a: word.toCharArray()){
            if(temp.child[a -'a'] == null){
                temp.child[a - 'a'] = new Trie();
            }
            temp = temp.child[a-'a'];
        }
        temp.end = true;
    }

    String replace(String word){
        Trie temp = this;
        StringBuilder sb = new StringBuilder();
        for(char a: word.toCharArray()){
            if(temp.child[a-'a'] == null) return word;

            sb.append(a);
            temp = temp.child[a-'a'];
            if(temp.end) return sb.toString();

        }
        return word;
//        Trie temp = this;
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < word.length(); i++) {
//            int id = word.charAt(i) - 'a';
//            sb.append(word.charAt(i));
//            if(Objects.isNull(temp.child[id])) {
//                return word;
//            }
//            temp = temp.child[id];
//            if(temp.end) {
//                return sb.toString();
//            }
//        }
//        return sb.toString();
    }
}

class ReplaceWords {

    public String replaceWords(String sentence, List<String> dictionary) {
        Trie root = new Trie();

        HashMap<String,String> map = new HashMap<>();
        for(String s : dictionary){
            root.insert(s);
        }
        String[] inputs = sentence.split(" ");
        String[] te = new String[inputs.length];
        int i = 0;
        System.out.println("strings" + Arrays.toString(inputs));
        for(String a: inputs ){
            a = a.trim();
            String newword = "";
            if(!map.containsKey(a)){
                newword = root.replace(a);
                map.put(a,newword);
            }else{
                newword = map.get(a);
            }
            System.out.println("newword" + newword);
            te[i++] = newword;
        }
        return String.join(" ", te);

    }

    // driver code
    public static void main(String[] args) {
        ReplaceWords s = new ReplaceWords();
        String[] sentence = {
                "the cattle was rattled by the battery"
        };
        List<List<String>> dictionary = Arrays.asList(Arrays.asList("cat","bat","rat"));

        for (int i = 0; i < sentence.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput sentence: '" + sentence[i] + "'");
            System.out.println("\tDictionary words: '" + dictionary.get(i) + "'");
            System.out.println("\tAfter replacing words: '" + s.replaceWords(sentence[i], dictionary.get(i)) + "'");
            //System.out.println(PrintHyphens.repeat("-", 100));
        }

    }
}