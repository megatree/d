package index.t;

import index.util.ClassIntrospector;
import okhttp3.Response;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by wangzhe.bj on 2017/8/2.
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException {





        for (int i = 0; i < 128; i++) {
            System.out.println(String.format("i=%d\t\ti&(n-1)=%d\ti取余n=%d\t\ti&n=%d",i,i&15,i%16,i&16));
        }
    }


    static public class User {
        private static User user = new User("1");

        public String name;

        public User(String name) {
            this.name = name;
            System.out.println(name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


}
