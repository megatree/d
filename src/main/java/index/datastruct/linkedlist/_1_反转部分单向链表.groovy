package index.datastruct.linkedlist

import index.collections.linkedlist.Node
import index.util.NodeUtils

/**
 * Created by wangzhe.bj on 2018/3/27.
 */

/**
 * 1、如不满足1<=from<=to<=N，则返回原头节点
 * 2、如
 * @param head
 * @param from
 * @param to
 */
def reversePartList(Node head, int from, int to) {
    def len = 0 as int
    def tHead = head
    Node nPrev
    Node nNext
    while (head != null) {
        len++

        if (len + 1 == from) {
            nPrev = head
        }

        head = head.next

        if (len + 1 == to) {
            nNext = head?.next
        }
    }

    println "len=$len from=${from} to=${to}"

    if (!(1 <= from && from <= to && to <= len)) {
        return tHead
    }


    head = tHead
    def pre
    def next
    def i = 1
    Node nFrom, nTo
    while (head != null) {
        //记录from to节点
        //记录from to之前 之后一个节点

        if (from <= i && i <= to) {
            if (from == i) {
                nFrom = head
            }

            if (to == i) {
                nTo = head
            }

            next = head.next
            head.next = pre

            pre = head
            head = next
        } else {
            head = head.next
        }
        i++
    }

    //如果nPrev不为null，返回tHead
    //如果nPrev为null，nNext 不为null，返回to那个节点
    //如果nPrev、nNext为null，返回to节点

    if (nPrev != null) {
        nPrev.next = nTo
        nFrom.next = nNext
        return tHead
    }

    if ( nNext != null) {
        nFrom.next = nNext
        return nTo
    }

    return nTo
}


Closure<Node> reverse = { len, from, to -> println reversePartList(NodeUtils.createNodeList(len), from, to) }
reverse(8, 0, 9)
reverse(8, 4, 8)
reverse(8, 3, 6)
