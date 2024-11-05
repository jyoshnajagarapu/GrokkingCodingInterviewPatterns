import java.util.*;

public class InMemoryFileSystem {
    public static void main(String[] args) {


          FileSystem obj = new FileSystem();
          List<String> param_1 = obj.ls("/");
          obj.mkdir("/a/b/c");
          obj.addContentToFile("/a/b/c/d","hello");
        List<String> param_2 = obj.ls("/");
          String param_4 = obj.readContentFromFile("/a/b/c/d");
        List<String> param_5 = obj.ls("/a/b/c/d");

    }
}

class FileSystem {
    boolean isFile;
    String name;
    StringBuilder content;
    HashMap<String, FileSystem> child;
    public FileSystem() {
        content = new StringBuilder() ;
        child = new HashMap<>();
        name = "";
        isFile = false;
    }
    public FileSystem(String n) {
        content = new StringBuilder();
        child = new HashMap<>();
        name = n;
        isFile = false;
    }


    public List<String> ls(String path) {
        ArrayList<String> res = new ArrayList<>();
        FileSystem node = this;
        String[] p = path.substring(1).split("/");
        for(String c : p){
            if(node.child.get(c) != null) node = node.child.get(c);
        }
        if(node == null) return res;
        if(node.isFile) {
            System.out.println(node.name);
            res.add(node.name);
            return res;
        }
        res.addAll(node.child.keySet());
        Collections.sort(res);
        return res;


    }

    public void mkdir(String path) {
        FileSystem node = this;
        String[] p = path.substring(1).split("/");
        for(String c : p){
            if(node.child.get(c) == null) node.child.put(c , new FileSystem(c));
            node = node.child.get(c);
        }

    }

    public void addContentToFile(String filePath, String content) {
        FileSystem node = this;
        String[] p = filePath.substring(1).split("/");
        for(String c : p){
            if(node.child.get(c) == null) node.child.put(c , new FileSystem(c));
            node = node.child.get(c);
        }
        node.isFile = true;
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        FileSystem node = this;
        String[] p = filePath.substring(1).split("/");
        for(String c : p){
            node = node.child.get(c);
        }
        return node.content.toString();
    }
}
