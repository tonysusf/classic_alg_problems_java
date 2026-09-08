import java.util.*;


/*
* javac BinaryTreeBfsTraverse.java; java -ea BinaryTreeBfsTraverse
* https://leetcode.com/problems/binary-tree-level-order-traversal/
*/

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class BinaryTreeBfsTraverse {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        System.out.println("Output is " + result);
        return result;
    }


    public static void main(String[] args) {
        BinaryTreeBfsTraverse s = new BinaryTreeBfsTraverse();

        // 1. Empty tree
        assert s.levelOrder(null) == null;

        // 2. Single node
        Node root1 = new Node(1);

        assert s.levelOrder(root1).equals(List.of(List.of(1)));

        // 3. Complete tree
        //
        //       1
        //      / \
        //     2   3
        //
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        assert s.levelOrder(root2).equals(
            List.of(List.of(1), List.of(2, 3))
        );

        // 4. LeetCode example
        //
        //        3
        //       / \
        //      9   20
        //         /  \
        //        15   7
        //
        Node root3 = new Node(3);
        root3.left = new Node(9);
        root3.right = new Node(20);
        root3.right.left = new Node(15);
        root3.right.right = new Node(7);

        assert s.levelOrder(root3).equals(
            List.of(
                List.of(3),
                List.of(9, 20),
                List.of(15, 7)
            )
        );

        // 5. Left-skewed tree
        //
        //     1
        //    /
        //   2
        //  /
        // 3
        //
        Node root4 = new Node(1);
        root4.left = new Node(2);
        root4.left.left = new Node(3);

        assert s.levelOrder(root4).equals(
            List.of(
                List.of(1),
                List.of(2),
                List.of(3)
            )
        );

    }
}