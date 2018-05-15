package index.leetcode_cn.链表;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-15.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/46/
 * 你能否不使用额外空间解决此题？
 */
public class 环形链表 {

    @Test
    public void go() {

    }

    /**
     * 1 ms
     * 94%
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        int index = 1;
        while (fast != null) {
            if ((index & 1) == 0) {
                slow = slow.next;
            }
            fast = fast.next;

            if (slow == fast) {
                return true;
            }
            index++;
        }

        return false;

    }
}
