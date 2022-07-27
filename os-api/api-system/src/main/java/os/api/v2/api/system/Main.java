package os.api.v2.api.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * os.api.v2.api.system
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 16:31
 */
@SpringBootApplication(scanBasePackages = "os.api.v2.api.system")
@ComponentScan({
        "os.api.v2.api.system",
        "os.api.v2.common.auth.config",
        "os.api.v2.common.auth.handle",
})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}