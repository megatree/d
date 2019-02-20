package index.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * <p>
 * Each 0 marks an empty land which you can pass by freely.
 * <p>
 * Each 1 marks a building which you cannot pass through.
 * <p>
 * Each 2 marks an obstacle which you cannot pass through.
 * <p>
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 * <p>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 * <p>
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 * <p>
 * 求最小距离和，一般最短路径问题应用BFS
 */
public class Shortest_Distance_from_All_Buildings {

    @Test
    public void test() {
        int[][] grid = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };

        int path = shortestDistance(grid);
        System.out.println(path);
    }

    /**
     * 最短路径
     * BFS
     *
     * @param grid
     * @return
     */
    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        if (rows <= 0) {
            return -1;
        }
        int cols = grid[0].length;

        //建立两个二维数组，分别表示每个位置的距离之和 和 可连通的buildings个数
        int[][] dist = new int[rows][cols];
        int[][] nums = new int[rows][cols];

        int buildingNums = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    //这个点是建筑物，计算这个点到每个0点的距离
                    bfs(grid, i, j, dist, nums);
                    buildingNums++;
                }
            }
        }

        //寻找buildings数量相等且最短距离
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (buildingNums == nums[i][j]) {
                    minDistance = Math.min(minDistance, dist[i][j]);
                }
            }
        }

        //存在有效最短路径和
        if (minDistance < Integer.MAX_VALUE) {
            return minDistance;
        }

        return -1;
    }

    /**
     * （i,j）为当前building的坐标，这时需要处理其上下左右位置的距离，
     * 使用Queue
     *
     * @param grid
     * @param i
     * @param j
     * @param dist
     * @param nums
     */
    private void bfs(int[][] grid, int i, int j, int[][] dist, int[][] nums) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int[][] directs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int distance = 0;

        while (!queue.isEmpty()) {
            //基础坐标 i j更换时，此值才发生变化
            distance++;

            //因为在此之后添加的点，都是原位置的四个方向，因此distance是不变的，都是1
            //不能随循环增加
            int k = queue.size();
            for (int l = 0; l < k; l++) {
                int[] coords = queue.poll();
                for (int m = 0; m < directs.length; m++) {
                    int x = coords[0] + directs[m][0];
                    int y = coords[1] + directs[m][1];

                    //不越界且未访问且是path
                    if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        dist[x][y] += distance;
                        nums[x][y]++;
                        //这个点放入队列，下次求这个点的四个方向
                        queue.add(new int[]{x, y});
                    }

                }
            }


        }


    }

}
