package index.datastruct.linkedlist

import index.collections.linkedlist.Node

/**
 * Created by wangzhe.bj on 2018/3/28.
 *
 * 时间O（N），空间O（1）
 * 需要改变链表状态
 * 1、找到中间节点，将链表右半部分逆序
 * 2、从链表两头同时遍历，检查值是否相等
 * 3、链表恢复原状
 */


def init() {
    Node head = new Node(1)
    head.setNext(
            new Node(2).setNext(
                    new Node(3).setNext(
                            new Node(2).setNext(
                                    new Node(1))
                    )
            )
    )
    head
}

def head = init()

println '原始链表'
println head

/**
 * 是否回文
 * @param head
 * @return
 */
boolean isPalindrome(Node head) {
    if (head == null || head.next == null) {
        //无节点或只有一个节点时，是回文
        true
    }

    Node slow = fast = head
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next    //慢指针一步
        fast = fast.next.next   //快指针两步
    }

    Node mid = slow
    Node r1 = mid       //r1为中点
    Node r2 = mid.next  //右半区域第一个节点
    mid.next = null
    Node rnext = null
    while (r2 != null) {
        rnext = r2.next
        r2.next = r1
        r1 = r2
        r2 = rnext
    }

    println '反转之后两条链表'
    println head
    println r1

    Node f1 = head
    Node f2 = r1

    boolean flag = true
    while (f1 != null && f2 != null) {
        if (f1.data != f2.data) {
            flag = false
        }
        f1 = f1.next
        f2 = f2.next
    }


    false
}

isPalindrome(head)
