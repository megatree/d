package index.datastruct.linkedlist

import index.collections.linkedlist.Node
import index.util.NodeUtils

/**
 * Created by wangzhe.bj on 2018/3/26.
 *
 *
 删除链表中间节点，当链表长度为
 0、1 不删除任何节点
 2 删除1
 3 删除2
 4 删除2
 5 删除3
 6 删除3
 7 删除4

 快指针走两步，慢指针走一步
 */


def removeMidNode(Node head) {
    if (head == null || head.next == null) {
        return head
    }

    def slow = head
    def fast = head
    def i = 0
    def prev

    while (fast != null) {
        i++
        // 快指针走到3时，慢指针再开始
        if ((i & 1) == 0 && i > 2) {
            prev = slow
            slow = slow.next
        }
        fast = fast.next
    }

    prev.next = slow.next
    head
}

def head = NodeUtils.createNodeList(8)

println removeMidNode(head)