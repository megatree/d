package index.common;

/**
 * Created by mythss on 2018-05-21.
 */
public class MatrixUtils {

    public static void print(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int i1 = 0; i1 < m[i].length; i1++) {
                System.out.print(m[i][i1]+" ");
            }
            System.out.println();
        }
    }
}
