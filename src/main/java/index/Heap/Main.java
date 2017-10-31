package index.Heap;

/**
 * Created by wangzhe.bj on 2017/8/21.
 */
public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(1);
        heap.insert(4);
        heap.insert(9);
        heap.insert(2);
        heap.insert(3);
        heap.insert(11);
        heap.insert(24);
        heap.insert(50);
        heap.insert(16);
        heap.insert(32);
        heap.printAll();
    }
}
