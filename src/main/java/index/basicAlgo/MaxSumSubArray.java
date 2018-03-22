package index.basicAlgo;

/**
 * Created by wangzhe.bj on 2017/7/25.
 */
public class MaxSumSubArray {

    public static void main(String[] args) {

        int[] arr = {3,-6,1,2,3,-1,2,-5,1,2};
        find3(arr);
    }

    /*
    动态规划
     */
    public static void find3(int[] array){
        int lastSum = 0;
        int maxSum = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < array.length; i++) {
            if (lastSum>0){
                lastSum = lastSum+array[i];
            }else{
                lastSum = array[i];
                start=i;
            }

            if (maxSum<lastSum){
                maxSum = lastSum;
                end=i;
            }
        }
    }
}
