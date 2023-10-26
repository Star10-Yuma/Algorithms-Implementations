public class BinaryTree {

    // The root of the binary tree
    private Node root;

    // Node class to represent individual nodes in the tree
    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // Method to insert a new node into the binary tree
    public void insert(int value) {
        root = insert(root, value);
    }

    // Helper method to insert a new node recursively
    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;
    }

    // Method to delete a node from the binary tree
    public void delete(int value) {
        root = delete(root, value);
    }

    // Helper method to delete a node recursively
    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value == node.value) {
            // Case 1: node has no children
            if (node.left == null && node.right == null) {
                return null;
            }
            // Case 2: node has one child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            // Case 3: node has two children
            int minValue = minValue(node.right);
            node.value = minValue;
            node.right = delete(node.right, minValue);
            return node;
        } else if (value < node.value) {
            node.left = delete(node.left, value);
            return node;
        } else {
            node.right = delete(node.right, value);
            return node;
        }
    }

    // Helper method to find the minimum value in a subtree
    private int minValue(Node node) {
        int minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }

    // Method to search for a value in the binary tree
    public boolean search(int value) {
        return search(root, value);
    }

    // Helper method to search for a value recursively
    private boolean search(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (node.value == value) {
            return true;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    // Method to traverse the binary tree in-order
    public void inorder() {
        inorder(root);
    }

    // Helper method to traverse the binary tree in-order recursively
    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    // Method to traverse the binary tree in pre-order
    public void preorder() {
        preorder(root);
    }

    // Helper method to traverse the binary tree in pre-order recursively
    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Method to traverse the binary tree in post-order
    public void postorder() {
        postorder(root);
    }

    // Helper method to traverse the binary tree in post-order recursively
    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);
        tree.delete(5);
        System.out.println(tree.search(7)); // Output: true
        System.out.println(tree.search(8)); // Output: false
        tree.inorder(); // Output: 1 3 5 7 9
        System.out.println();
        tree.preorder(); // Output: 5 3 1 7 9
        System.out.println();
        tree.postorder(); // Output: 1 3 9 7 5

    }
}
