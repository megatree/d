package index.questions;

import index.linkedlist.Node;
import index.util.NodeUtils;

/**
 * Created by wangzhe.bj on 2017/11/5.
 */
public class 反转链表 {

    public static void main(String[] args) {
        Node head = NodeUtils.createNodeList(10);

        System.out.println(head.toString());
        System.out.println(recReverse(head));
    }

    /**
     * 非递归反转链表
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        if (head == null) {
            return null;
        }

        Node left = head;
        Node right = left.getNext();
        left.setNext(null);

        while (right != null) {
            Node temp = right.getNext();
            right.setNext(left);
            left = right;
            right = temp;
        }

        return left;
    }

    /**
     * 递归反转链表
     *
     * @param head
     * @return
     */
    public static Node recReverse(Node head) {

        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }

        Node newHead = recReverse(head.getNext());

        head.getNext().setNext(head);
        head.setNext(null);

        return newHead;


    }
}
