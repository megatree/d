package index.leetcode_cn中级.链表;

import index.leetcode_cn.链表.ListNode;
import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-24.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/83/
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes为节点总数。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class 奇偶链表 {

    @Test
    public void go() {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        //至此至少有2个节点

        int index = 0;
        ListNode cur = head;
        ListNode lastOddNode = cur;
        ListNode lastEvenNode = cur.next;
        ListNode headEven = lastEvenNode;

        //从第3位开始遍历
        cur = lastEvenNode.next;
        while (cur != null) {
            index++;
            boolean isOdd = index % 2 == 1;
            ListNode next = cur.next;

            if (isOdd) {
                lastOddNode.next = cur;
                lastOddNode = cur;
            } else {
                lastEvenNode.next = cur;
                lastEvenNode = cur;
            }
            cur = next;
        }

        lastEvenNode.next = null;

        //最后一个奇数位后面拼上偶数位链表
        lastOddNode.next = headEven;
        return head;
    }
}
