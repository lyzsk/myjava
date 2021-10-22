package cn.sichu.myjava.october2021.binarytreeproblem;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int val, Node left, Node right) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node(int val, Node left, Node right, Node next) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public Node(int val) {
        super();
        this.val = val;
    }

    public Node() {

    }

}
