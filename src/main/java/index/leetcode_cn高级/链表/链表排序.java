package index.leetcode_cn高级.链表;

import index.leetcode_cn.链表.ListNode;
import org.junit.Test;

/**
 * Created by mythss on 2018-07-08.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/56/linked-list/135/
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class 链表排序 {

    @Test
    public void go() {

    }

    /**
     * 快排解法，有bug
     *
     * @param head
     * @return
     */
    public ListNode sortList_(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        //只交换值，不交换结点
        quickSort(head, cur);
        return head;
    }

    public void quickSort(ListNode begin, ListNode end) {
        if (begin == null || begin == end || begin.next == null) {
            //无元素或只剩一个元素
            return;
        }

        ListNode mid = partition(begin, end);
        quickSort(begin, mid);
        quickSort(mid.next, end);

    }

    /**
     * 存在bug
     *
     * @param begin
     * @param end
     * @return
     */
    public ListNode partition(ListNode begin, ListNode end) {
        if (begin == null || begin == end || begin.next == null) {
            return begin;
        }

        int pivot = begin.val;
        ListNode storeIndex = begin;

        //把pivot暂存到最后一位
        swapListNode(begin, end);

        //遍历链表，不包括最后一位
        ListNode cur = begin;
        while (cur.next != null) {
            //如果当前小于pivot，那么当前与storeIndex交换，同时storeIndex后移
            if (cur.val < pivot) {
                swapListNode(cur, storeIndex);
                storeIndex = storeIndex.next;
            }
            cur = cur.next;
        }

        //末尾与storeIndex交换
        swapListNode(end, storeIndex);

        return storeIndex;
    }

    public void swapListNode(ListNode l1, ListNode l2) {
        int temp = l1.val;
        l1.val = l2.val;
        l2.val = temp;
    }

    /**
     * 递归形式的归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head; //slow 前一位
        //不包括最后一个
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表断为2个
        prev.next = null;
        return merge(sortList(head), sortList(slow));
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    /**
     * 非递归合并
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;
        ListNode cur;
        if (l1.val < l2.val) {
            head = l1;
            cur = l1;
            l1 = l1.next;
        } else {
            head = l2;
            cur = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return head;
    }


}
