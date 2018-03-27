package index.datastruct.linkedlist

import index.collections.linkedlist.DoubleNode
import index.collections.linkedlist.Node
import index.util.NodeUtils

/**
 * Created by wangzhe.bj on 2018/3/27.
 */

/**
 * 判断右面节点不为空
 * @param head
 * @return
 */
def reverseList(Node head) {
    def pre
    def next
    while (head != null) {
        //1、先挂上next
        //2、反转指针
        //3、pre head右移
        next = head.next
        head.next = pre

        pre = head
        head = next
    }
    return pre
}

/**
 * 反转双向链表
 * @param head
 */
def reverseDoubleList(DoubleNode head) {
    def pre
    def next
    while (head != null) {
        next = head.next
        head.next = pre
        head.prev = next

        pre = head
        head = next
    }
    return pre
}

def list = NodeUtils.createNodeList(8)
println reverseList(list)

def doubleList = NodeUtils.createDoubleNodeList(8, 1);
println reverseDoubleList(doubleList)
