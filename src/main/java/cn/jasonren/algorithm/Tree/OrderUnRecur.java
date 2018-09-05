package cn.jasonren.algorithm.Tree;

import java.util.Stack;

public class OrderUnRecur {
    public void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        Stack<Node> stack = new Stack<>();
        if (head != null) {
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.add(head.right);
                }
                if (head.left != null) {
                    stack.add(head.left);
                }
            }
        }

    }


    public void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        Stack<Node> stack = new Stack<>();
        if (head != null) {
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.add(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
    }


    public void postOrderUnRecur1(Node head) {
        System.out.print("post-order: ");
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        if (head != null) {
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }

                if (head.right != null) {
                    s1.push(head.right);
                }
            }

            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(6);
        root.left.right = new Node(7);
        root.right.left = new Node(8);
        new OrderUnRecur().preOrderUnRecur(root);
        System.out.println();
        new OrderUnRecur().inOrderUnRecur(root);
        System.out.println();
        new OrderUnRecur().postOrderUnRecur1(root);
        System.out.println();
        // new OrderUnRecur().postOrderUnRecur2(root);
    }
}
