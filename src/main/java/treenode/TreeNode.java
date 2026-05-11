package main.java.treenode;

public class TreeNode<T> {
    T data;
    TreeNode left;
    TreeNode right;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode(T data, TreeNode left, TreeNode right) {
        this.data = data;
    }

    public void addLeft(TreeNode left) {
        this.left = left;
    }

    public void addLeft(T lefData) {
        this.left = new TreeNode(lefData);
    }

    public void addRight(TreeNode right) {
        this.right = right;
    }

    public void addRight(T rightData) {
        this.right = new TreeNode(rightData);
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
