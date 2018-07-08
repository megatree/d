package index.leetcode_cn高级.链表;

import index.leetcode_cn.链表.ListNode;
import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-06-20.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/56/linked-list/134/
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class 合并K个元素的有序链表 {

    @Test
    public void go() {

    }

    /**
     * 常规方法，250ms
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists_(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode node = null;
        ListNode head = null;
        ListNode cur = null;
        while ((node = search(lists)) != null) {
            if (head == null) {
                //第一次初始化
                head = node;
                cur = node;
                continue;
            }
            //后面的直接在后面累加
            cur.next = node;
            cur = cur.next;
        }

        return head;
    }


    public ListNode search(ListNode[] lists) {
        ListNode minNode = null;

        //遍历数组，返回最小原节点
        int minIndex = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                if (minIndex == i) {
                    minIndex++;
                }
                continue;
            }

            if (lists[minIndex].val > lists[i].val) {
                minIndex = i;
            }
        }

        if (minIndex >= lists.length) {
            //此时说明整个链表数组为空
            return null;
        }

        //取出最小结点
        minNode = lists[minIndex];
        //后移一位
        lists[minIndex] = lists[minIndex].next;
        //next置空
        minNode.next = null;
        return minNode;
    }
////////////////////////////////////////////////////////////////

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return work(lists, 0, lists.length - 1);
    }

    public ListNode work(ListNode[] lists, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {

            ListNode l1 = work(lists, left, mid);
            ListNode l2 = work(lists, mid + 1, right);
            return mergeTwo(l1, l2);
        }

        return lists[left];
    }

    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            //以l1为基础
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwo(l2.next, l1);
            return l2;
        }
    }

}
