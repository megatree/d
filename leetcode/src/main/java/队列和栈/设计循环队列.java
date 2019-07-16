package 队列和栈;

import org.junit.Test;

/**
 * @Author: wangzhe
 * @Date: 2019-07-16
 */
public class 设计循环队列 {

    @Test
    public void go() {

        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3

        circularQueue.enQueue(1);  // 返回 true

        circularQueue.enQueue(2);  // 返回 true

        circularQueue.enQueue(3);  // 返回 true

        circularQueue.enQueue(4);  // 返回 false，队列已满

        circularQueue.Rear();  // 返回 3

        circularQueue.isFull();  // 返回 true

        circularQueue.deQueue();  // 返回 true

        circularQueue.enQueue(4);  // 返回 true

        circularQueue.Rear();  // 返回 4

    }


    public static class MyCircularQueue {

        private int[] data;
        private int   head;
        private int   tail;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            this.data = new int[k];
            this.head = -1;
            this.tail = -1;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            //入队条件，没满
            if (this.isFull()) {
                return false;
            }

            if (head < 0) {
                head = 0;
            }

            //入队从队尾进
            if (++tail >= data.length) {
                tail = 0;
            }
            data[tail] = value;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (this.isEmpty()) {
                return false;
            }

            //只剩最后一个元素，重置指针
            if (head == tail) {
                head = tail = -1;
                return true;
            }

            if (++head >= data.length) {
                head = 0;
            }
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (head >= 0) {
                return data[head];
            }
            return -1;
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (tail >= 0) {
                return data[tail];
            }
            return -1;
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return head < 0 && tail < 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return (head - tail == 1) || (tail - head == data.length - 1);
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
