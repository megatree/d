package index.leetcode_cn高级.链表;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhe.bj on 2018-07-09.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/56/linked-list/136/
 * <p>
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深度拷贝。
 */
public class 复制带随机指针的链表 {

    @Test
    public void go() {

    }

    /**
     * 超时
     * @param head
     * @return
     */
    public RandomListNode copyRandomList_(RandomListNode head) {
        if (head == null) {
            return null;
        }

        //对每个节点进行复制，插入原节点后面
        RandomListNode node = head;
        while (node != null) {
            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }

        //根据原节点random，给新节点random赋值
        RandomListNode c = head;

        while (c != null) {
            if (c.random != null) {
                //复制节点的random指向复制节点
                c.next.random = c.random.next;
            }
        }

        RandomListNode newhead = head.next;

        //拆分链表
        RandomListNode n = head;
        while (n != null) {
            RandomListNode newnode = n.next;
            n.next = newnode.next;
            if (newnode.next!=null){
                newnode.next = newnode.next.next;
            }
            n = n.next;
        }

        return newhead;
    }

    /**
     *
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        //map 用来存原节点的复制节点
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur!=null){
            RandomListNode newNode = new RandomListNode(cur.label);
            map.put(cur,newNode);
            cur = cur.next;
        }

        cur = head;
        while (cur!=null){
            RandomListNode node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
