package index.questions;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/e95337f886f54110b92318f693cd8fad
 * 来源：牛客网
 * <p>
 * DNA分子是以4种脱氧核苷酸为单位连接而成的长链，这4种脱氧核苷酸分别含有A,T,C,G四种碱基。碱基互补配对原则：A和T是配对的，C和G是配对的。如果两条碱基链长度是相同的并且每个位置的碱基是配对的，那么他们就可以配对合成为DNA的双螺旋结构。现在给出两条碱基链，允许在其中一条上做替换操作：把序列上的某个位置的碱基更换为另外一种碱基。问最少需要多少次让两条碱基链配对成功
 * 输入描述:
 * <p>
 * 输入包括一行： 包括两个字符串,分别表示两条链,两个字符串长度相同且长度均小于等于50。
 * <p>
 * <p>
 * 输出描述:
 * <p>
 * 输出一个整数，即最少需要多少次让两条碱基链配对成功
 * 示例1
 * 输入
 * <p>
 * ACGT TGCA
 * 输出
 * <p>
 * 0
 * Created by wangzhe.bj on 2017/11/3.
 */
public class DNACombine {

    public static void main(String[] args) {
        String line1 = "ATCG GCTA TAAA";
        String line2 = "CGCG ATGA GACC";

        if (line1 == null || line2 == null) {
            return;
        }

        if (line1.length() != line2.length()) {
            return;
        }

        int countAsc = 0, countDesc = 0;


        for (int i = 0; i < line1.length(); i++) {
            char l1 = line1.charAt(i);
            char l2 = line2.charAt(i);
            char l3 = line2.charAt(line2.length() - 1 - i);

            if (isMatch(l1, l2)) {
                continue;
            } else {
                countAsc++;
            }

            if (isMatch(l1, l3)) {
                continue;
            } else {
                countDesc++;
            }
        }

        System.out.println(Math.min(countAsc, countDesc));
        System.out.println(countAsc + " " + countDesc);

    }

    private static boolean isMatch(char l1, char l2) {
        return (l1 == ' ' && l2 == ' ') || (l1 == 'A' && l2 == 'T') || (l1 == 'T' && l2 == 'A') || (l1 == 'C' && l2 == 'G') || (l1 == 'G' && l2 == 'C');
    }
}
