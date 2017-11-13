package index.questions;

import index.collections.linkedlist.Node;

/**
 * 查找链表中倒数第K个节点
 * 注意代码鲁棒性
 * <p>
 * Created by wangzhe.bj on 2017/11/5.
 */
public class 链表倒数K个节点 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(null);

        Node k = findKthNodeTail(n1, 0);
        System.out.println(k.getData());


    }

    public static Node findKthNodeTail(Node head, int k) {
        if (head == null) {
            throw new IllegalArgumentException("链表不能为空");
        }

        if (k<=0){
            throw new IllegalArgumentException("k 范围不对");
        }

        int index = 0;
        int indexEnd = k - 1;
        Node t = head;
        Node cur = head;

        while (t != null) {

            t = t.getNext();
            if (index > indexEnd) {
                cur = cur.getNext();
            }

            index++;
        }

        if (index < indexEnd) {
            throw new IllegalArgumentException("k 超出范围");
        }

        return cur;


    }
}
