package os.api.v2.api.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * os.api.v2.api.user
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 16:30
 */
@SpringBootApplication(scanBasePackages = "os.api.v2.api.user")
<<<<<<< HEAD
=======
@ComponentScan({
        "os.api.v2.api.user",
        "os.api.v2.common.auth"
})
>>>>>>> 820c11b723601d5f9988218df24f69961847af03
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}