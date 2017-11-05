package index.questions;

import index.linkedlist.ComplexNode;

/**
 * Created by wangzhe.bj on 2017/11/5.
 */
public class 复杂链表的复制 {

    public static void main(String[] args) {
        ComplexNode c1 = new ComplexNode(1);
        ComplexNode c2 = new ComplexNode(2);
        ComplexNode c3 = new ComplexNode(3);
        ComplexNode c4 = new ComplexNode(4);
        ComplexNode c5 = new ComplexNode(5);

        c1.setNext(c2);
        c2.setNext(c3);
        c3.setNext(c4);
        c4.setNext(c5);

        c1.setSibling(c3);
        c2.setSibling(c5);
        c4.setSibling(c2);

        ComplexNode complexNode = copy(c1);

    }

    public static ComplexNode copy(ComplexNode head) {
        //给每个节点复制一个链接到后面
        int max = 0;
        ComplexNode node = head;
        while (node != null) {
            ComplexNode cloneNode = new ComplexNode(node.getValue());
            ComplexNode next = node.getNext();
            node.setNext(cloneNode);
            cloneNode.setNext(next);

            node = node.getNext();
            max++;
        }

        ComplexNode c = head;
        int index = 0;
        while (index < 2 * max) {
            if (index % 2 == 0) {
                //偶数个，原node
                if (c.getSibling() != null) {
                    c.getNext().setSibling(c.getSibling());
                }

            }

            index++;
        }

        //恢复链表
        ComplexNode n = head;
        ComplexNode newHead = n.getNext();
        ComplexNode temp = newHead;
        while (n != null) {
            n.setNext(temp.getNext());
            n = temp.getNext();
            temp.setNext(n.getNext());
            temp = n.getNext();

        }

        return newHead;
    }


}
