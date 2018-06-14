package index.questions;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhe.bj on 2018-06-14.
 */
public class 脉脉dfs算法题 {

    private List<List<Integer>> result = new LinkedList<>();

    @Test
    public void go() {
        Map<Integer, int[]> map = new LinkedHashMap<>();
        map.put(41, new int[]{42, 43});
        map.put(42, new int[]{44});
        map.put(43, new int[]{45, 46});
        map.put(44, new int[]{47, 48});
        map.put(45, new int[]{49});
        map.put(46, new int[]{50});

        System.out.println(map);

    }

    public void dfs(Map<Integer, int[]> map, List<Integer> buffer, int key) {
        if (map.get(key)==null){
            return;
        }

        int[] arr = map.get(key);

        for (int i = 0; i < arr.length; i++) {

        }
    }


}
