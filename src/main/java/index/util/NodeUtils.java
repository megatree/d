package index.util;

import index.collections.linkedlist.Node;

/**
 * Created by wangzhe.bj on 2017/11/5.
 */
public class NodeUtils {

    public static Node createNodeList(int length) {
        return createNodeList(length, 1);
    }

    public static Node createNodeList(int length, int begin) {
        Node head = new Node(begin);
        Node cur = head;

        for (int i = begin; i < begin+length-1; i++) {
            Node t = new Node(i + 1);
            cur.setNext(t);
            cur = t;
        }
        return head;
    }

    public static Node getLastNode(Node head) {
        Node t = head;
        Node tail = null;
        while (t != null) {
            tail = t;
            t = t.getNext();
        }
        return tail;
    }

    public static Node getIndexedNode(Node head, int index) {
        Node t = head;
        int i = 0;
        while (t != null) {
            if (i == index) {
                return t;
            }
            t = t.getNext();
            i++;
        }
        return null;
    }
}
