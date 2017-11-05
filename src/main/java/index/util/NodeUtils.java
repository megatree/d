package index.util;

import index.linkedlist.Node;

/**
 * Created by wangzhe.bj on 2017/11/5.
 */
public class NodeUtils {

    public static Node createNodeList(int length) {
        Node head = new Node(1);
        Node cur = head;

        for (int i = 1; i < length; i++) {
            Node t = new Node(i + 1);
            cur.setNext(t);
            cur = t;
        }
        return head;
    }
}
