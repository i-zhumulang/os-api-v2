package os.api.v2.api.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * os.api.v2.api.auth
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 */
@SpringBootApplication(scanBasePackages = "os.api.v2.api.auth")
@ComponentScan({
        "os.api.v2.api.auth",
        "os.api.v2.common.auth.config"
})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}