package index.leetcode_cn.链表;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-15.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/44/
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class 合并两个有序链表 {

    @Test
    public void go() {


    }

    /**
     * 使用原有链表结点，未创建新的链表结点
     * 12 ms
     * 73.21%
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        //至此，两个链表均至少有一个节点
        //原链表上插入，不创建新链表
        ListNode main;
        ListNode sub;

        //确定主链表和辅助链表
        if (l1.val <= l2.val) {
            main = l1;
            sub = l2;
        } else {
            main = l2;
            sub = l1;
        }

        ListNode head = main;
        while (main != null && sub != null) {
            ListNode nextMain = main.next;
            ListNode nextSub = sub.next;

            //sub = main当前元素，直接拼在main元素后面
            if (main.val == sub.val) {
                main.next = sub;
                sub.next = nextMain;

                //main后移
                main = main.next;
                //sub后移
                sub = nextSub;

                continue;
            }

            if (main.val < sub.val) {
                //main后面直接为空，拼上sub剩余链表
                if (main.next == null) {
                    main.next = sub;
                    break;
                }

                //main后面还有元素
                //main.next比sub 大，合适位置
                if (main.next.val >= sub.val) {
                    main.next = sub;
                    sub.next = nextMain;

                    main = main.next;
                    sub = nextSub;

                    continue;
                }

                //sub比main.next还大，sub不动，main后移一位
                main = main.next;
                continue;
            }
        }
        return head;

    }
}
