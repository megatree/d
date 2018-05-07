package index.综合题系列1;

import java.util.Random;

/**
 * Created by wangzhe.bj on 2018/5/2.
 */
public class 拆红包 {

    public static void main(String[] args) {
        RedPackage redPackage = new RedPackage();
        redPackage.remainMoney = 100;
        redPackage.remainSize = 10;

        for (int i = 0; i < 10; i++) {
            System.out.println(getRandomMoney(redPackage));
        }
    }

    public static double getRandomMoney(RedPackage _redPackage) {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (_redPackage.remainSize == 1) {
            _redPackage.remainSize--;
            return (double) Math.round(_redPackage.remainMoney * 100) / 100;
        }
        Random r = new Random();
        double min = 0.01;
        double max = _redPackage.remainMoney / _redPackage.remainSize * 2;
        double money = r.nextDouble() * max;
        money = money <= min ? 0.01 : money;
        money = Math.floor(money * 100) / 100;
        _redPackage.remainSize--;
        _redPackage.remainMoney -= money;

        System.out.println("此时平均值2倍为 "+max);
        return money;
    }

    public static class RedPackage {
        int    remainSize;
        double remainMoney;
    }


}
