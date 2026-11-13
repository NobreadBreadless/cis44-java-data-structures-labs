// TODO: Implement the AVLNode class
class AVLNode {
    int key, height;
    AVLNode left, right;

    // Constructor
    AVLNode(int key) {
        // TODO: Initialize key, height, left, and right
        this.key = key;
        this.height = 0;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {

    AVLNode root;

    // TODO: Return height of a node
    int height(AVLNode N) {
        if (N == null) {
            return 0;
        } else {
            return N.height;
        }
    }

    // TODO: Return maximum of two integers
    int max(int a, int b) {
        if (a < b) return b;
        else return a;

    }

    // TODO: Compute balance factor
    int getBalance(AVLNode N) {
        if (N == null) {
            return 0;
        } else {
            return height(N.left) - height(N.right);
        }
    }

    // TODO: Right rotation
    AVLNode rightRotate(AVLNode y) {
        return null; // placeholder
    }

    // TODO: Left rotation
    AVLNode leftRotate(AVLNode x) {
        return null; // placeholder
    }

    // TODO: Left-Right rotation
    AVLNode leftRightRotate(AVLNode z) {
        return null; // placeholder
    }

    // TODO: Right-Left rotation
    AVLNode rightLeftRotate(AVLNode y) {
        return null; // placeholder
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // TODO: Recursive insertion with rebalancing
    private AVLNode insert(AVLNode node, int key) {
        return null; // placeholder
    }

    // TODO: Traversal methods
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        // placeholder
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        // placeholder
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        // placeholder
    }
}