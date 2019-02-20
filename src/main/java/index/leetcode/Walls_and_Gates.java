package index.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangzhe.bj on 2019-02-20.
 * <p>
 * You are given a m x n 2D grid initialized with these three possible values.
 * <p>
 * -1 - A wall or an obstacle.
 * <p>
 * 0 - A gate.
 * <p>
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * <p>
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * <p>
 * For example, given the 2D grid:
 * <p>
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * After running your function, the 2D grid should be:
 * <p>
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 * <p>
 * https://segmentfault.com/a/1190000004184488
 */
public class Walls_and_Gates {

    int[][] rooms = {
            {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
            {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
            {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {-1, -1, 0, 0},
    };

    @Test
    public void go() {
        wallsAndGates(rooms);
        for (int[] room : rooms) {
            System.out.println(Arrays.toString(room));
        }
    }


    /**
     * BFS，从门开始扫
     *
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        if (rows == 0) {
            return;
        }
        int cols = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] coords = queue.poll();

            for (int i = 0; i < directs.length; i++) {
                int x = coords[0] + directs[i][0];
                int y = coords[1] + directs[i][1];

                if (x >= 0 && x < rows && y >= 0 && y < cols && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = Math.min(rooms[x][y], rooms[coords[0]][coords[1]] + 1);
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
