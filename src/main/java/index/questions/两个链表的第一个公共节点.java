package index.questions;

import index.collections.linkedlist.Node;
import index.util.NodeUtils;

/**
 * Created by wangzhe.bj on 2017/11/15.
 */
public class 两个链表的第一个公共节点 {

    public static void main(String[] args) {

        Node n1 = NodeUtils.createNodeList(8);
        Node n2 = NodeUtils.createNodeList(5);

        System.out.println(n1.toString());

        Node n2t = NodeUtils.getLastNode(n2);
        Node n1m = NodeUtils.getIndexedNode(n1, 3);
        n2t.setNext(n1m);

        System.out.println(n2.toString());

        System.out.println(findFirstCommonNode(n1, n2).getData());

    }

    public static Node findFirstCommonNode(Node n1, Node n2) {
        if (n1 == null || n2 == null) {
            return null;
        }

        int l1 = getNodeLength(n1);
        int l2 = getNodeLength(n2);
        int diff = Math.abs(l1 - l2);

        Node longList = l1 > l2 ? n1 : n2;
        Node shorList = l1 > l2 ? n2 : n1;

        for (int i = 0; i < diff; i++) {
            longList = longList.getNext();
        }

        while ((longList != null) &&
                (shorList != null) &&
                (longList.getData() != shorList.getData())) {

            longList = longList.getNext();
            shorList = shorList.getNext();
        }

        return longList;

    }

    public static int getNodeLength(Node n) {
        Node t = n;
        int l = 0;
        while (t != null) {
            l++;
            t = t.getNext();
        }
        return l;
    }


}
