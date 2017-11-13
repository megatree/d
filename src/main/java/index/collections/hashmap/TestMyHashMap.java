package index.collections.hashmap;

/**
 * Created by wangzhe.bj on 2017/11/13.
 */
public class TestMyHashMap {

    public static void main(String[] args) {

        MyHashMap<String,String> map = new MyHashMap<>();
        map.put("1","11");
        map.put("2","22");
        map.put("3","33");
        map.put("1","00");

        System.out.println(map.size());
        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
        System.out.println(map.get("3"));

    }
}
