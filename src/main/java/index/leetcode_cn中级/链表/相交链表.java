package index.leetcode_cn中级.链表;

import index.leetcode_cn.链表.ListNode;
import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-24.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/84/
 */
public class 相交链表 {

    @Test
    public void go() {

    }

    /**
     * 2ms
     * 81.2%
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        if (headA==headB){
            return headA;
        }

        ListNode l1 = headA;
        ListNode l2 = headB;

        int moreLen = 0;
        while (l1 != null && l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode longNode = headA;
        ListNode shortNode = headB;
        ListNode countNode = null;
        if (l1 != null && l2 == null) {
            countNode = l1;
            longNode = headA;
            shortNode = headB;
        } else if (l1 == null && l2 != null) {
            countNode = l2;
            shortNode = headA;
            longNode = headB;
        }

        //计算剩余长度
        while (countNode != null) {
            moreLen++;
            countNode = countNode.next;
        }

        while (moreLen > 0) {
            moreLen--;
            longNode = longNode.next;
        }

        while (longNode != null && shortNode != null) {
            if (longNode == shortNode) {
                return longNode;
            }

            longNode = longNode.next;
            shortNode = shortNode.next;
        }

        return null;

    }
}
