import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    // Check if node is full (3 keys)
    public boolean isFull() {
        return keys.size() == 3;
    }

    // Find correct child to descend for a given key
    public TwoFourNode getNextChild(int key) {
        // TODO: Implement traversal logic
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert a key into this node (assume node not full)
    public void insertKey(int key) {
        // TODO: Add key and sort
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // 2. Insert key in leaf
        node.insertKey(key);

        // 3. Handle overflow by splitting
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // TODO: Implement split logic
        // 1. Create a new right node
        // 2. Promote middle key to parent
        // 3. Move keys and children appropriately
        // 4. Update parent pointers
        System.out.println("Splitting node with keys: " + node.keys);
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }
}
