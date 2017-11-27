package index.正确程序写法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangzhe.bj on 2017/11/27.
 */
public class 遍历List删除元素 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String  str = it.next();
            if (str == "3"){
                it.remove();
            }
        }

        System.out.println(Arrays.toString(list.toArray()));

    }
}
