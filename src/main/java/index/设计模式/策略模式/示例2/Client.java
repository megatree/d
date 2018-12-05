package index.设计模式.策略模式.示例2;

/**
 * Created by wangzhe.bj on 2018-12-05.
 */
public class Client {

    public static void main(String[] args) {

        System.out.println(Calculator.ADD.exec(1,2));
        System.out.println(Calculator.SUB.exec(1,2));

    }
}
