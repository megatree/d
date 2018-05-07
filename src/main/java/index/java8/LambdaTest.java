package index.java8;

import com.google.common.collect.Lists;
import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by wangzhe.bj on 2018/4/20.
 */
public class LambdaTest {

    public static void main(String[] args) {

    }

    public void test() {
        List<User> userList = Lists.newArrayList();
        userList.add(new User(1, 0401, 1, 8));
        userList.add(new User(1, 0402, 2, 7));
        userList.add(new User(1, 0403, 3, 6));
        userList.add(new User(2, 0401, 4, 2));
        userList.add(new User(2, 0401, 5, 3));
        userList.add(new User(3, 0401, 6, 4));
        userList.add(new User(4, 0401, 7, 5));

        userList.stream()
                .collect(Collectors.groupingBy(User::getBcid))
                .entrySet().parallelStream()
                .map(integerListEntry -> integerListEntry.getValue()
                        .stream()
                        .reduce((u1, u2) -> {
                            u1.count += u2.count;
                            u1.sum += u2.sum;
                            u1.setSampleDate(0);
                            return u1;
                        }))
                .collect(Collectors.toList())
                .forEach(u -> u.ifPresent(System.out::println));


    }


    public void testLock() {
        Holder holder = new Holder();
        new Thread(holder::lock).start();
        new Thread(holder::lock).start();
        new Thread(holder::normal).start();
    }

    static class Holder {

        public void lock() {
            System.out.println(Thread.currentThread().getName() + "准备进入");
            synchronized (LambdaTest.class) {
                System.out.println(Thread.currentThread().getName() + "已经进入");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "退出");
        }

        public void normal() {
            System.out.println("进入普通方法");
        }

    }


    @Data
    @ToString
    @AllArgsConstructor
    static class User {
        private int bcid;
        private int sampleDate;
        private int count;
        private int sum;
    }
}
