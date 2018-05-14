package index.leetcode_cn.链表;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-14.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/41/
 * <p>
 * <p>
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。
 * <p>
 * 比如：假设该链表为 1 -> 2 -> 3 -> 4  ，给定您的为该链表中值为 3 的第三个节点，那么在调用了您的函数之后，该链表则应变成 1 -> 2 -> 4 。
 */
public class 删除链表的结点 {

    @Test
    public void go() {


    }


    /**
     * 删除非末尾节点
     * 给的是要删除的节点，并未给链表头节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
