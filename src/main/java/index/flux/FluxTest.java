package index.flux;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

/**
 * @Author: wangzhe
 * @Date: 2019-07-03
 */
public class FluxTest {

    private Long start;

    @Before
    public void before() {
        start = System.currentTimeMillis();
    }

    @After
    public void after() {
        Long diff = System.currentTimeMillis() - start;
        System.out.println("耗时：" + diff + "ms");
    }

    @Test
    public void test() throws InterruptedException {
        String join = CompletableFuture.supplyAsync(() -> get(3, "任务1"))
                .thenCombine(CompletableFuture.supplyAsync(() -> get(4, "任务2")), (s1, s2) -> String.format("[%s] [%s]", s1, s2))
                .thenCombine(CompletableFuture.supplyAsync(() -> get(2, "任务3")), (s1, s2) -> String.format("%s [%s]", s1, s2))
                .thenCombine(CompletableFuture.supplyAsync(() -> getInt(2,"ex")),(s,i)->s+" 合并数字"+i)
                .join();
        System.out.println(join);

    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> get(3, "任务1"));
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> getInt(4, "ex"));

        String join = task1.get();
        Integer join1 = task2.get();

        System.out.println(join);
        System.out.println(join1);

    }

    public String get(long seconds, String flag) {
        System.out.println(flag+" 开始");
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(flag+" 执行完成");
        return flag + "，用了 " + seconds + "秒";
    }

    public int getInt(long seconds, String flag) {
        System.out.println(flag+" 开始");
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (flag.equalsIgnoreCase("ex")){
            throw new RuntimeException("抛异常啦");
        }
        System.out.println(flag+" 执行完成");
        return 111;
    }


}
