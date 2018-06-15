package index.questions;

import org.junit.Test;

import java.util.*;

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

        bfs(map);
        System.out.println(result);
    }

    /**
     * 应采用宽度优先遍历
     */
    public void bfs(Map<Integer, int[]> srcMap) {

        List<Integer> curList = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(41);

        //当前层次剩余
        int curLevelLeft = 1;
        //下一层次数量
        int nextLevelCount = 0;

        while (queue.size() > 0) {
            Integer i = queue.poll();
            curLevelLeft--;
            curList.add(i);

            int[] arr = srcMap.get(i);
            if (arr == null) {
                continue;
            }

            for (int i1 = 0; i1 < arr.length; i1++) {
                queue.offer(arr[i1]);
                nextLevelCount++;
            }

            if (curLevelLeft==0){
                //当前层遍历完成，收尾进数组
                result.add(curList);
                curList = new LinkedList<>();

                //重置计数器
                curLevelLeft = nextLevelCount;
                nextLevelCount = 0;
            }
        }

        result.add(curList);

    }

}
