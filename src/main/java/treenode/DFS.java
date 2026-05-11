package main.java.treenode;

public class DFS {

    public static void printTreeNode_Left_Root_Right(TreeNode root) {
        if (root == null) {
            return;
        }

        printTreeNode_Left_Root_Right(root.left); // => 3 => 2 =>
        System.out.println(root.data);
        printTreeNode_Left_Root_Right(root.right);
    }

    public static void printTreeNode_Node_Left_Right(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        printTreeNode_Node_Left_Right(root.left); // => 3 => 2 =>
        printTreeNode_Node_Left_Right(root.right);
    }

    public static void printTreeNode_Left_Right_Node(TreeNode root) {
        if (root == null) {
            return;
        }

        printTreeNode_Left_Right_Node(root.left); // => 3 => 2 =>
        printTreeNode_Left_Right_Node(root.right); //


        System.out.println(root.data);
    }


    static void main() {
        TreeNode root = new TreeNode(10);
        root.addLeft(3);


        root.getLeft().addLeft(2);
        root.getLeft().addRight(6);
        root.getLeft().getRight().addLeft(4);
        root.getLeft().getRight().addRight(7);


        root.addRight(15);

        root.getRight().addLeft(11);
        root.getRight().addRight(16);


        /*
                        10

             3                      15

       2          6          11        16

               4    7

         */


        printTreeNode_Left_Right_Node(root);
    }
}
