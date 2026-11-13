package binaryTree;

public class ElementOfNthLevel {
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

    public static void elementOfNthLevel(Node root, int n) {
        if (root == null)
            return;
        if (n == 1)
            System.out.print(root.val + " ");
            
        elementOfNthLevel(root.left, n - 1);
        elementOfNthLevel(root.right, n - 1);
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
        elementOfNthLevel(root,  2);
    }
}
