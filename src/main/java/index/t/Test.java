package index.t;

import index.util.ClassIntrospector;
import okhttp3.Response;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by wangzhe.bj on 2017/8/2.
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException {

        char[] c = new char[10];
        c[0] = 'a';

        String a = new String(c);

        System.out.println(a);

    }

    public enum E {
        ABC("def"),
        GHI("k");

        E(String def) {
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
