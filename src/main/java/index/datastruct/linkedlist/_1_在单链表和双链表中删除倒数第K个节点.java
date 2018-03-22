package index.datastruct.linkedlist;

import index.collections.linkedlist.Node;
import index.util.NodeUtils;

/**
 * Created by wangzhe.bj on 2018/3/22.
 */
public class _1_在单链表和双链表中删除倒数第K个节点 {

    public static void main(String[] args) {

        Node head = NodeUtils.createNodeList(2);
        System.out.println(head.toString());

        Node n = removeLastKthNode(head, 3);
        System.out.println(n.toString());

    }

    /**
     * 单链表删除倒数第K个
     *
     * @param head
     * @param k
     * @return
     */
    public static Node removeLastKthNode(Node head, int k) {

        Node cur = head;
        int n = 0;
        Node fast = cur;
        Node slow = cur;
        Node prev = null;

        //fast需要先走两步
        while (fast != null) {
            n++;
            if (n > k) {
                prev = slow;
                slow = slow.getNext();
            }
            fast = fast.getNext();
        }

        //链表长度没有k个，返回原节点
        //此种情况包含head为null的
        if (n < k) {
            return head;
        }

        if (n == k) {
            return head.getNext();
        }

        //n > k
        //单链表删除节点
        prev.setNext(slow.getNext());
        slow.setNext(null);
        return head;
    }
}
