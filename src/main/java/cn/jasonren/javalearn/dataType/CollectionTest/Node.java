package cn.jasonren.javalearn.dataType.CollectionTest;

public class Node {

    //数据域
    public int data;

    //指针域，指向下一个节点
    public Node next;

    public Node() {}

    public Node(final int data) {
        this.data = data;
    }

    public Node(final int data, final Node next) {
        this.data = data;
        this.next = next;
    }

    static Node head = new Node();

    /**
     * 向链表添加数据
     *
     * @param value 要添加的数据
     */
    public static void addData(int value) {
        //初始化要加入的节点
        Node newNode = new Node(value);

        //临时节点
        Node temp = head;

        //找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }

        //已经包括了头结点.next为null的情况
        temp.next = newNode;
    }

    /**
     * 遍历链表
     *
     * @param head 头结点
     */
    public static void traverse(Node head) {
        Node temp = head.next;

        while (temp != null) {
            System.out.println("当前节点为：" + temp.data);


            //继续下一个
            temp = temp.next;
        }
    }

    public static void insertNode(Node head, int index, int value) {
        if (index < 1 || index > LinkListLength(head) + 1) {
            System.out.println("插入位置不合法");
            return;
        }

        //临时节点
        Node temp = head;

        //记录遍历的当前位置
        int currentPos = 0;

        //初始化要插入的节点
        Node insertNode = new Node(value);

        while (temp.next != null) {

            //找到上一个节点的位置了
            if ((index - 1) == currentPos) {

                //temp表示的是上一个节点

                //将原本由上一个节点的指向交由插入的节点来指向
                insertNode.next = temp.next;


                //将上一个节点的指针域指向要插入的节点
                temp.next = insertNode;

                return;
            }

            currentPos++;
            temp = temp.next;
        }
    }

    public static void deleteNode(Node head, int index) {

        //首先需要判断指定位置是否合法
        if (index < 1 || index > LinkListLength(head) + 1) {
            System.out.println("删除位置不合法");
            return;
        }

        //指定节点，从头结点开始
        Node temp = head;

        //记录遍历的当前位置
        int currentPos = 0;

        while (temp.next != null) {

            if ((index - 1) == currentPos) {
                //temp表示的是上一个节点
                //temp.next表示的是想要删除的节点
                //将想要删除的节点存储一下
                Node deleteNode = temp.next;

                //想要删除节点的下一个节点交由上一个节点来控制
                temp.next = deleteNode.next;
                //Java会回收它，设置不设置为null应该没多大意义了
                deleteNode = null;
                return;
            }
            currentPos++;
            temp = temp.next;
        }
    }

    public static void sortLinkList(Node head) {
        Node currentNode;

        Node nextNode;

        for (currentNode = head.next; currentNode.next != null; currentNode = currentNode.next) {
            for (nextNode = currentNode.next; nextNode.next != null; nextNode = nextNode.next) {
                if (nextNode.data > nextNode.next.data) {
                    int temp = nextNode.data;
                    nextNode.data = nextNode.next.data;
                    nextNode.next.data = temp;
                }
            }
        }
    }

    public static Node findKNode(Node head, int k) {
        if (k < 1 || k > LinkListLength(head)) {
            return null;
        }

        Node p1 = head;
        Node p2 = head;

        //p2比p1快k个节点
        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p1;
    }

    public static void deleteDuplicate(Node head) {
        //临时节点，从首节点开始 --> 真正有数据的节点
        Node temp = head.next;

        //当前节点（首节点）的下一个节点
        Node nextNode;

        while (temp.next != null) {
            nextNode = temp;
            while (nextNode.next != null) {
                if (nextNode.next.data == nextNode.data) {
                    //将下一个节点删除（当前节点指向下一个节点）
                    nextNode.next = nextNode.next.next;
                } else {
                    //继续下一个
                    nextNode = nextNode.next;
                }
            }

            temp = temp.next;
        }
    }


    public static Node reverseLinkList(Node node) {
        Node prev;

        if(node == null || node.next == null) {
            prev = node;
        } else {
            Node tmp = reverseLinkList(node.next);
            node.next.next = node;
            node.next = null;
            prev = tmp;
        }
        return prev;
    }


    public static int LinkListLength(Node head) {
        int length = 0;

        //临时节点
        Node temp = head.next;

        //找到尾节点
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public static void main(String[] args) {
        addData(3);
        addData(4);
        addData(5);
        addData(3);

        traverse(head);
        Node newHead = reverseLinkList(head.next);
        System.out.println("------------");
        traverse(newHead);
    }
}
