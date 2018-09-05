package cn.jasonren.algorithm.Tree;

public class OrderRecur {
    public void preOrderRecur(Node head) {
        if (head == null) return;
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void inOrderRecur(Node head) {
        if (head == null) return;
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public void postOrderRecur(Node head) {
        if (head == null) return;
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(6);
        root.left.right = new Node(7);
        root.right.left = new Node(8);
        System.out.print("preOrder is ");
        new OrderRecur().preOrderRecur(root);
        System.out.println();
        System.out.print("inOrder is ");
        new OrderRecur().inOrderRecur(root);
        System.out.println();
        System.out.print("postOrder is ");
        new OrderRecur().postOrderRecur(root);
    }
}
