import java.util.*;

/*
* javac MaxDepthBinaryTree.java; java -ea MaxDepthBinaryTree
* https://leetcode.com/problems/climbing-stairs/description/
*/

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class MaxDepthBinaryTree {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        System.out.println("depth is " + depth);
        return depth;
    }

    public static void main(String[] args) {
        MaxDepthBinaryTree s = new MaxDepthBinaryTree();

        // 1. Empty tree
        assert s.maxDepth(null) == 0;

        // 2. Single node
        Node root1 = new Node(1);
        assert s.maxDepth(root1) == 1;

        // 3. Two levels
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        assert s.maxDepth(root2) == 2;

    }
}
