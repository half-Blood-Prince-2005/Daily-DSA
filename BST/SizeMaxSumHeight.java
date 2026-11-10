package BST;

public class SizeMaxSumHeight {
    public static class Node {
        int val;
        Node right;
        Node left;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // traversal
    // pre order traversal
    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // finding size of the tree
    public static int size(Node root) {
        if (root == null)
            return 0;
        return 1 + size(root.left) + size(root.right);
    }

    // finding the sum of the nodes
    public static int sum(Node root) {
        if (root == null)
            return 0;
        int sumL = sum(root.left);
        int sumR = sum(root.right);
        return root.val + sumL + sumR;
    }

    public static int max(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        return 1 + Math.max(lHeight, rHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(6);
        b.right = e;
        System.out.println(max(root));

    }

}
