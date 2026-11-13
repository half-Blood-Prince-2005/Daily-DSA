package binaryTree;

public class DiameterOfBinaryTree {
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

    public static int height(Node root) {
        if (root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);

        return 1 + Math.max(lheight, rheight);
    }

    public static int diameter(Node root) {
        if (root == null)
            return 0;
        int currentNodeDiameter = height(root.left) + height(root.right);
        int leftNodeDiameter = diameter(root.left);
        int rightNodeDiameter = diameter(root.right);
        return Math.max(currentNodeDiameter, Math.max(leftNodeDiameter, rightNodeDiameter));
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
        Node f = new Node(7);
        b.left = e;
        b.right = f;
        System.out.println(diameter(root));
    }
}
