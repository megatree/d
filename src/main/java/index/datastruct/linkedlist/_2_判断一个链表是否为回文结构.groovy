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

    //遍历，判断是否回文
    println '准备比较'
    boolean flag = true
    while (f1 != null && f2 != null) {
        println "f1[${f1.data}] : f2[${f2.data}]"
        if (f1.data != f2.data) {
            flag = false
            break
        }
        f1 = f1.next
        f2 = f2.next
    }

    println '准备复原链表'
    println r1

    //链表复原
    Node t1 = r1
    Node t2 = r1.next
    Node tnext
    t1.next = null
    while (t2 != null) {
        tnext = t2.next
        t2.next = t1
        t1 = t2
        t2 = tnext
    }

    println '复原'
    println head

    println "这个链表[${flag?'是':'不是'}]回文链表"
    flag
}

isPalindrome(head)
