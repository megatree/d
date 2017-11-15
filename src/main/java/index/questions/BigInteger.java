package index.questions;

/**
 * Created by wangzhe.bj on 2017/11/4.
 */
public class BigInteger {

    public static void main(String[] args) {
        String s1 = "1111111111111111111111111111111111111111111111111111111";
        String s2 = "-222222222222222222222222222222222222222222222222222222222222";

        System.out.println(add(s1, s2));
    }

    public static String add(String a, String b) {
        char sign = '+';

        char sign1 = a.charAt(0);
        char sign2 = b.charAt(0);

        String num1 = "";
        String num2 = "";

        //确定两个数字符号
        if (sign1 == '+' || sign1 == '-') {
            num1 = a.substring(1);
        } else {
            num1 = a;
            sign1 = '+';
        }

        if (sign2 == '+' || sign2 == '-') {
            num2 = b.substring(1);
        } else {
            num2 = b;
            sign2 = '+';
        }


        //反转数字顺序并且补0
        StringBuilder sb1 = new StringBuilder(num1).reverse();
        StringBuilder sb2 = new StringBuilder(num2).reverse();

        int distance = Math.abs(sb1.length() - sb2.length());
        if (sb1.length() > sb2.length()) {
            for (int i = 0; i < distance; i++) {
                sb2.append("0");
            }
        } else {
            for (int i = 0; i < distance; i++) {
                sb1.append("0");
            }
        }

        char[] arr1 = sb1.toString().toCharArray();
        char[] arr2 = sb2.toString().toCharArray();


        //a是否大于b
        boolean isLarger = num1.length() > num2.length() || num1.compareTo(num2) > 0;
        int[] mids = new int[arr1.length + 1];
        String result = "";

        //同号
        if (sign1 == sign2) {
            sign = sign1;

            for (int i = 0; i < arr1.length; i++) {
                mids[i] = Character.getNumericValue(arr1[i]) + Character.getNumericValue(arr2[i]);
            }

            //处理进位
            for (int i = 0; i < mids.length - 1; i++) {
                if (mids[i] >= 10) {
                    mids[i + 1] += 1;
                    mids[i] %= 10;
                }
            }
        } else {
            //异号大数减小数
            //符号跟随大数
            if (isLarger){
                sign = sign1;
                for (int i = 0; i < arr1.length; i++) {
                    mids[i] = Character.getNumericValue(arr1[i]) - Character.getNumericValue(arr2[i]);
                }
            }else {
                sign = sign2;
                for (int i = 0; i < arr1.length; i++) {
                    mids[i] = Character.getNumericValue(arr2[i]) - Character.getNumericValue(arr1[i]);
                }
            }

            for (int i = 0; i < mids.length-1; i++) {
                if (mids[i]<0) {
                    mids[i + 1] -= 1;
                    mids[i] += 10;
                }
            }
        }


        for (int i = mids.length - 1; i >= 0; i--) {
            result += mids[i];
        }
        result = result.charAt(0) == '0' ? result.substring(1) : result;
        result = sign == '+' ? result : sign + result;

        return result;
    }

}
