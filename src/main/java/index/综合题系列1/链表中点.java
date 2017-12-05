package index.综合题系列1;

import index.collections.linkedlist.Node;
import index.util.NodeUtils;

/**
 * Created by wangzhe.bj on 2017/12/5.
 */
public class 链表中点 {

    public static void main(String[] args) {
        Node head = NodeUtils.createNodeList(8);
        middleNodes(head);
    }

    public static void middleNodes(Node root) {
        if (root==null){
            return;
        }

        Node h = root;

        int ptrFast = 0;
        int ptrSlow = 0;
        int index=0;

        while (h != null) {
            index++;




            h = h.getNext();
        }
    }


}
