package binaryTree;

public class MinProduct {

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

    public static int minValue(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        int lMin = minValue(root.left);
        int rMin = minValue(root.right);
        return Math.min(root.val, Math.min(lMin, rMin));
    }

    public static int productValue(Node root) {
        if (root == null)
            return 1;

        int lProduct = productValue(root.left);
        int rProduct = productValue(root.right);

        return root.val * lProduct * rProduct;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(-4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(6);
        b.right = e;
        System.out.println(productValue(root));

    }
}
