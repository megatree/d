package index.设计模式.策略模式.示例2;

/**
 * Created by wangzhe.bj on 2018-12-05.
 */
public enum Calculator {

    ADD("+") {
        @Override
        public int exec(int a, int b) {
            return a + b;
        }
    },
    SUB("-") {
        @Override
        public int exec(int a, int b) {
            return a - b;
        }
    };

    String value;

    Calculator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract int exec(int a, int b);
}
