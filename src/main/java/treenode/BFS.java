package main.java.treenode;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void traverseBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.getLeft());
            }
            if (node.right != null) {
                queue.add(node.getRight());
            }
        }
    }

    static void main() {
        TreeNode root = new TreeNode(10);
        root.addLeft(3);


        root.getLeft().addLeft(2);
        root.getLeft().addRight(6);

        root.addRight(15);

        root.getRight().addLeft(11);
        root.getRight().addRight(16);


        /*
                        10

             3                      15

       2          6          11        16



         */

        traverseBFS(root);
    }
}
