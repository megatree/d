package index.leetcode_cn.链表;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-15.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/45/
 * <p>
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class 回文链表 {

    @Test
    public void go() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        assert !isPalindrome(n1);
    }

    /**
     * 快慢指针找到中点和末尾
     * 后半段反转指针
     * 两边同时遍历
     * <p>
     * On O1
     * 2ms
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        if (head.next == null) {
            return true;
        }

        //至少3个结点
        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode slow = head;
        ListNode fast = head;
        //计次
        int index = 1;
        while (fast.next != null) {
            if ((index & 1) == 0) {
                slow = slow.next;
            }
            fast = fast.next;
            index++;
        }

        ListNode mid = slow;

        System.out.println(mid.val);

        //后半段反转指针
        ListNode l = mid.next;
        ListNode r = l.next;
        mid.next = null;
        l.next = null;

        while (r != null) {
            ListNode next = r.next;
            r.next = l;
            l = r;
            r = next;
        }

        //从两端遍历比较值
        ListNode n1 = head;
        ListNode n2 = l;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        //是回文
        return true;
    }


    /**
     * 从两端比较，用cur = slow.next 不断将cur 拉回判断
     *
     * @param head
     * @return
     */
    public boolean isPalindrome_2(ListNode head) {


        if (head == null || head.next == null) {
            return true;
        }
        if (head.val == head.next.val && head.next.next == null) {
            return true;
        }
        //到这时，链表的长度为3
        ListNode slow = head;
        ListNode cur = head.next;
        while (cur.next != null) {
            if (cur.next.val == slow.val) {
                if (cur.next.next != null) {
                    return false;
                }
                cur.next = null;
                slow = slow.next;
                cur = slow.next;
                if (cur == null || slow.val == cur.val) {
                    return true;
                }
            } else {
                cur = cur.next;
            }
        }
        return false;
    }
}
