package index.leetcode_cn;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by wangzhe.bj on 2018-05-10.
 */
public class Info {

    HashCodeBuilder builder = new HashCodeBuilder();

    {
        builder.append(1).build();
    }

    public static void main(String[] args) {
        AClass user = new AClass(123);
        Object c = user;
        System.out.println(c.toString());

    }

    public static class AClass{
        private int a;

        public AClass() {
        }

        public AClass(int a) {
            this.a = a;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return "AClass{" +
                    "a=" + a +
                    '}';
        }
    }
}
