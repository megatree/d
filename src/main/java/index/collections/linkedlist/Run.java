package index.collections.linkedlist;

/**
 * Created by wangzhe.bj on 2017/7/13.
 */
public class Run {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        System.out.println(node1.toString());
        System.out.println(reverse(node1));



    }

    public static Node reverse(Node head) {
        if (head == null) {
            return head;
        }

        Node left = head;
        Node right = left.getNext();
        head.setNext(null);

        while (right != null) {
            Node temp = right.getNext();

            right.setNext(left);

            left = right;
            right = temp;
        }

        return left;
    }
}
