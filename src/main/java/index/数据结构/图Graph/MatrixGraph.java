package index.数据结构.图Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 邻接矩阵表示法
 */
public class MatrixGraph {
    // 下标与实际值的映射
    private int[]   mapping;
    //图的二维数组
    private int[][] matrix;

    /**
     * 初始化图
     */
    public MatrixGraph(int[] vertexes) {
        int length = vertexes.length;
        mapping = new int[length];
        matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            mapping[i] = vertexes[i];
        }
    }

    public void addEdge(int start, int end) {
        int x = -1;
        int y = -1;
        //寻找坐标
        for (int i = 0; i < mapping.length; i++) {
            if (x != -1 && y != -1) {
                //上一轮已给x y赋值
                break;
            }

            if (start == mapping[i]) {
                x = i;
            }

            if (end == mapping[i]) {
                y = i;
            }
        }

        //判断顶点是否存在
        if (x == -1 || y == -1 || x > mapping.length - 1 || y > mapping.length - 1) {
            return;
        }
        //赋值
        matrix[x][y] = 1;
    }


    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                System.out.print(matrix[i][i1]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * DFS 深度优先遍历
     * 使用栈的方式
     */
    public void depthFirstTravel() {
        Stack<Integer> stack = new Stack();
        //初始化访问状态数组
        int[] visited = new int[mapping.length];
        //从未访问的顶点中选择一个作为起始顶点
        int unvisited = getUnvisited(visited);
        while (unvisited >= 0) {
            //标记起始顶点已被访问
            visited[unvisited] = 1;
            //入栈
            stack.push(unvisited);
            System.out.print(mapping[unvisited] + ",");

            while (!stack.isEmpty()) {
                //获取栈顶元素，并不出栈
                int index = stack.peek();
                //遍历矩阵此行，找到未被访问的邻接节点
                boolean found = false;
                for (int i = 0; i < mapping.length; i++) {
                    if (index != i && visited[index] == 0 && matrix[index][i] > 0) {
                        //非自己 未被访问 邻接顶点
                        visited[i] = 1;
                        stack.push(i);
                        System.out.print(mapping[i] + ",");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    stack.pop();
                }
            }

            unvisited = getUnvisited(visited);
        }
    }

    /**
     * BFS 广度优先遍历
     */
    public void breadthFirstTravel() {
        Queue<Integer> queue = new LinkedList<>();

        int[] visited = new int[mapping.length];
        int unvisited = getUnvisited(visited);
        while (unvisited >= 0) {
            queue.add(unvisited);
            while (!queue.isEmpty()) {
                //顶点出队
                int index = queue.poll();
                if (visited[index] == 1) {
                    //访问过了，继续
                    continue;
                }

                System.out.print(mapping[index] + ",");

                visited[index] = 1;

                for (int i = 0; i < mapping.length; i++) {
                    //非自己 未被访问 可到达
                    if (index != i && visited[i] == 0 && matrix[index][i] > 0) {
                        queue.add(i);
                    }
                }
            }
            unvisited = getUnvisited(visited);

        }
        System.out.println();
    }

    private int getUnvisited(int[] visited) {
        int index = -1;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                index = i;
                break;
            }
        }

        return index;
    }

}
