package index.leetcode_cn.链表;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-15.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/43/
 */
public class 反转链表 {

    @Test
    public void go() {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode l = head;
        ListNode r = l.next;
        head.next = null;
        while (r != null) {
            ListNode next = r.next;
            r.next = l;

            //右移
            l = r;
            r = next;
        }

        return l;
    }

    /**
     * 反转单链表
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode l = head;
        ListNode r = head.next;
        l.next = null;

        while (r!=null){
            ListNode t = r.next;
            r.next = l;

            l = r;
            r = t;
        }

        return l;

    }
}
