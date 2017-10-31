package index.threadlocaltest;

/**
 * Created by wangzhe.bj on 2017/10/12.
 */
public class ThreadLocalUtil {

    private static ThreadLocal session = new ThreadLocal();

    public static Object getSession() {
        Object t = session.get();
        return t;
    }

    public static void setSession(Object ss) {
        session.set(ss);
    }
}
