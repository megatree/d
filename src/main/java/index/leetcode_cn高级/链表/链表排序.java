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
     * 可以用快速排序，或者归并排序（切分为多个有序链表，然后有序链表的合并）
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode cur = head;
        while (cur.next!=null){
            cur = cur.next;
        }

        //只交换值，不交换结点
        quickSort(head,cur);
        return head;
    }

    public void quickSort(ListNode begin, ListNode end) {
        if (begin == null || begin == end) {
            return;
        }

        ListNode mid = partition(begin, end);
        quickSort(begin, mid);
        quickSort(mid.next, end);

    }

    public ListNode partition(ListNode begin, ListNode end) {
        if (begin == null || begin == end) {
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

}
