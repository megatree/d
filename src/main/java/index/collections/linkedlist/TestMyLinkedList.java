package index.collections.linkedlist;

/**
 * Created by wangzhe.bj on 2017/11/13.
 */
public class TestMyLinkedList {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("0");

        list.remove(0);

        System.out.println(list.toString());

    }
}
