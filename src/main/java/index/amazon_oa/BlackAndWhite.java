package index.amazon_oa;

import org.junit.Test;

/**
 * 一个二维数组，0 1 分别表示黑白。其中横竖斜线邻接，认为其是完整一块。
 * 现在计算有多少黑块
 *
 */
public class BlackAndWhite {

    @Test
    public void go(){
        int[][] grid = {
                {1,1,0,1,0,0,1,1},
                {1,1,0,0,1,1,1,0},
                {0,1,1,0,0,0,1,0},
                {1,0,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,0},
        };
        System.out.println(regionCount(grid));
    }

    public int regionCount(int[][] matrix){


    }
}
