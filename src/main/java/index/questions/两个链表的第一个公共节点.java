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

        Node n2t = NodeUtils.getLastNode(n2);
        Node n1m = NodeUtils.getIndexedNode(n1,3);
        n2t.setNext(n1m);





    }


}
