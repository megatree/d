package index.t;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangzhe.bj on 2017/8/2.
 */
public class Test {

    public static void main(String[] args) {
       int a = 0;
       int b =96;
        String r = 1.0 * a / b * 100 + "0000";
        System.out.println(r);
        r = r.substring(0,r.indexOf(".")+3);
        System.out.println(r);

    }




    public static class User {
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
