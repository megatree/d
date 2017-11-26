package index.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangzhe.bj on 2017/11/26.
 */
public class 两个队列实现一个栈 {

    public static void main(String[] args) {
        Queue4Stack<String> stack = new Queue4Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("4");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public static class Queue4Stack<E> {

        private Queue<E> queue1 = new LinkedList<>();
        private Queue<E> queue2 = new LinkedList<>();

        public boolean push(E item) {
            Queue<E> q = null;
            if (!queue1.isEmpty()) {
                q = queue1;
            } else {
                q = queue2;
            }

            q.add(item);
            System.out.println("push->" + item);
            return true;
        }

        public E pop() {
            Queue<E> q = null;
            Queue<E> q2 = null;
            if (!queue1.isEmpty()) {
                q = queue1;
                q2 = queue2;
            } else {
                q = queue2;
                q2 = queue1;
            }

            while (!q.isEmpty() && q.size() > 1) {
                q2.add(q.poll());
            }

            return q.poll();
        }


    }
}
