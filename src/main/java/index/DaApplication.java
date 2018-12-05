package index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by wangzhe.bj on 2018-12-04.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaApplication.class, args);
    }

}
