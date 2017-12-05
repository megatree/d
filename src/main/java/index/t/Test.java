package index.t;

import index.util.ClassIntrospector;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wangzhe.bj on 2017/8/2.
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException {
        String c = null;
        String d = (c="北京市").substring(0,c.length()-1);
        System.out.println(d);


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
