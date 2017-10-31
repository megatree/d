package index.Heap;

/**
 * Created by wangzhe.bj on 2017/8/21.
 */
public class Heap {

    private int[] element;

    public Heap(int maxSize) {
        element = new int[maxSize + 1];
        element[0] = 0; //第一位用来存储元素个数，1~n用来存储元素
    }

    public boolean isEmpty() {
        return element[0] == 0;
    }

    public boolean isFull() {
        return element[0] == element.length - 1;
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("大顶堆满了");
        }

        if (isEmpty()) {
            element[1] = value;
        } else {
            //对于任意一个元素i，它的父节点一定为i/2
            int i = element[0] + 1;
            while (i != 1 && value > element[i / 2]) {
                //i不是第一个节点，并且比父节点大，则要上移
                element[i] = element[i / 2]; //父节点赋值给当前新增节点
                i /= 2; //i下标占据原父节点位置
            }
            element[i] = value;
        }
        element[0]++;
    }

    public int delete() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("满了");
        }

        int deleteElement = element[1];
        element[1] = element[element[0]];
        element[0]--;
        int temp = element[1];

        int parent = 1;
        int child = 2;

        while (child <= element[0]) {
            //child下标与有效元素总数比较，保证不越界
            if (child < element[0] && element[child] < element[child + 1]) {
                child++;
            }

            if (temp > element[child]) {
                break;
            } else {
                element[parent] = element[child];
                parent = child;
                child *= 2;
            }
        }

        element[parent] = temp;
        return deleteElement;
    }

    public void printAll() {
        for (int i = 0; i < element[0] + 1; i++) {
            System.out.print(element[i]);
            if (i != element[0]) {
                System.out.print(",");
            }
        }
    }
}
