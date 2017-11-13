package index.collections.arraylist;

/**
 * Created by wangzhe.bj on 2017/11/13.
 */
public class TestMyArrayList {

    public static void main(String[] args) {

        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        System.out.println(list.get(4));
        list.printInfo();
    }
}
