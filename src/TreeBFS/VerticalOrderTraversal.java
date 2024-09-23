package TreeBFS;

import java.util.*;
class Pair<T>{
    int col;
    TreeNode<T> node;
    public Pair(int col , TreeNode<T> node){
        this.col = col ;
        this.node = node;
    }
}
class Solution {
    public static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {
        List<List<Integer>> result  = new ArrayList<>();
        if(root == null) return result;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        ArrayDeque<Pair<Integer>> q = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        q.add(new Pair<Integer>(0 , root));
        while(!q.isEmpty()){
            Pair<Integer> p  = q.poll();
            min = Math.min(min , p.col);
            max = Math.max(max,p.col);
            map.computeIfAbsent(p.col , (l) -> new ArrayList<>()).add(p.node.data);
            if(p.node.left != null) q.add(new Pair<Integer>(p.col -1 , p.node.left));
            if(p.node.right != null) q.add(new Pair<Integer>(p.col +1 , p.node.right));
        }

        for(int i = min ; i <=max ; i++){
             List<Integer> temp = map.get(i);
             result.add(temp);
         }
        //System.out.println("result" +  result);
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(300), new TreeNode<Integer>(10), new TreeNode<Integer>(350), new TreeNode<Integer>(15)),
                Arrays.asList(new TreeNode<Integer>(20), new TreeNode<Integer>(40), new TreeNode<Integer>(50), new TreeNode<Integer>(90), new TreeNode<Integer>(67), new TreeNode<Integer>(94)),
                Arrays.asList(new TreeNode<Integer>(-10), new TreeNode<Integer>(-23), new TreeNode<Integer>(45), new TreeNode<Integer>(25), new TreeNode<Integer>(46)),
                Arrays.asList(new TreeNode<Integer>(9), new TreeNode<Integer>(7), null, null, new TreeNode<Integer>(1), new TreeNode<Integer>(8), new TreeNode<Integer>(10), null, new TreeNode<Integer>(12)),
                Arrays.asList(new TreeNode<Integer>(3), new TreeNode<Integer>(2), new TreeNode<Integer>(3), null, new TreeNode<Integer>(3), null, new TreeNode<Integer>(1))
        );

        List<BinaryTree<Integer>> inputTrees = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
            BinaryTree<Integer> tree = new BinaryTree<>(ListOfNodes);
            inputTrees.add(tree);
        }

        int x = 1;
        for (BinaryTree<Integer> tree : inputTrees) {
            System.out.println(x + ".\tInput Tree:");
            //Print.displayTree(tree.root);
            x++;
            System.out.println("\n\tVertical order: " + verticalOrder(tree.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}


class BinaryTree<T> {
    TreeNode<T> root;

    BinaryTree(List<TreeNode<T>> ListOfNodes) {
        root = createBinaryTree(ListOfNodes);
    }

    private TreeNode<T> createBinaryTree(List<TreeNode<T>> ListOfNodes) {
        if (ListOfNodes.isEmpty()) {
            return null;
        }

        // Create the root node of the binary tree
        TreeNode<T> root = new TreeNode<>(ListOfNodes.get(0).data);

        // Create a queue and add the root node to it
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);

        // Start iterating over the list of ListOfNodes starting from the second node
        int i = 1;
        while (i < ListOfNodes.size()) {
            // Get the next node from the queue
            TreeNode<T> curr = q.remove();

            // If the node is not null, create a new TreeNode object for its left child,
            // set it as the left child of the current node, and add it to the queue
            if (ListOfNodes.get(i) != null) {
                curr.left = new TreeNode<>(ListOfNodes.get(i).data);
                q.add(curr.left);
            }

            i++;

            // If there are more ListOfNodes in the list and the next node is not null,
            // create a new TreeNode object for its right child, set it as the right child
            // of the current node, and add it to the queue
            if (i < ListOfNodes.size() && ListOfNodes.get(i) != null) {
                curr.right = new TreeNode<>(ListOfNodes.get(i).data);
                q.add(curr.right);
            }

            i++;
        }

        // Return the root of the binary tree
        return root;
    }
}

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
