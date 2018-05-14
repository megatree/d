package index.leetcode_cn.链表;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-14.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/42/
 */
public class 删除链表的倒数第N个节点 {

    @Test
    public void go() {


    }


    /**
     * n 保证有效
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }

        ListNode preSlow = slow;
        while (fast.next != null) {
            preSlow = slow;

            fast = fast.next;
            slow = slow.next;
        }

        //slow 即为要删结点
        if (slow == head) {
            return slow.next;
        }

        //slow不是尾节点
        if (slow.next != null) {
            slow.val = slow.next.val;
            slow.next = slow.next.next;
        } else {
            //slow 是尾节点，需要从前一个删
            preSlow.next = null;
        }

        return head;

    }
}
