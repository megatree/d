package index.datastruct.linkedlist;

import index.collections.linkedlist.Node;
import index.util.NodeUtils;

/**
 * Created by wangzhe.bj on 2018/3/22.
 */
public class _1_打印两个有序链表公共部分 {

    public static void main(String[] args) {

        Node node1 = NodeUtils.createNodeList(5, 4);
        Node node2 = NodeUtils.createNodeList(8, 1);
        System.out.println(node1.toString());
        System.out.println(node2.toString());



        while (node1 != null && node2 != null) {
            if (node1.getData()<node2.getData()){
                node1 = node1.getNext();
            }else if (node1.getData()>node2.getData()){
                node2 = node2.getNext();
            }else{
                System.out.print(node1.getData()+"-");
                node1 = node1.getNext();
                node2 = node2.getNext();
            }

        }

    }
}
