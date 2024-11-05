import java.util.HashMap;
import java.util.List;
//https://leetcode.com/problems/design-file-system/

public class DesignFileSystem {
    public static void main(String[] args) {



          FileSystem1 obj = new FileSystem1();
//          boolean param_1 = obj.createPath(path,value);
//          int param_2 = obj.get(path);

    }

}
class FileSystem1 {
    HashMap<String, FileSystem1> child;
    int value;
    String name;
    public FileSystem1() {
        child = new HashMap<>();
        value = -1;
    }
    public FileSystem1(int val) {
        child = new HashMap<>();
        value = val;
    }

    public boolean createPath(String path, int value) {
        String[] p = path.substring(1).split("/");
        int n = p.length;
        FileSystem1 node = this;
        for(int i = 0 ;  i < n-1 ;i++){
            if(node.child.get(p[i]) == null) return false;
            node = node.child.get(p[i]);
        }
        if(node.child.get(p[n-1]) != null) return false;
        node.child.put(p[n-1], new FileSystem1(value));
        return true;

    }

    public int get(String path) {
        String[] p = path.substring(1).split("/");
        FileSystem1 node = this;
        int n = p.length;
        for(int i = 0 ;  i < n ;i++){
            if(node.child.get(p[i]) == null) return -1;
            node = node.child.get(p[i]);
        }
        return node.value;
    }
}
