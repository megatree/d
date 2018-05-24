package index.leetcode_cn中级.链表;

import index.leetcode_cn.链表.ListNode;
import org.junit.Test;

/**
 * Created by mythss on 2018-05-24.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/82/
 */
public class 两数相加 {

    @Test
    public void go() {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        ListNode result = new ListNode(0);
        ListNode head = result;

        //下一位要加
        int nextAdd = 0;

        ListNode cur2 = l2;
        while (cur != null || cur2 != null) {
            head.next = new ListNode(0);
            head = head.next;

            int sum = nextAdd;

            if (cur != null) {
                sum += cur.val;
                cur = cur.next;
            }
            if (cur2 != null) {
                sum += cur2.val;
                cur2 = cur2.next;
            }

            nextAdd = 0;
            if (sum >= 10) {
                nextAdd = 1;
            }

            head.val = sum % 10;

        }

        if (nextAdd > 0) {
            head.next = new ListNode(nextAdd);
        }
        return result.next;
    }
}
