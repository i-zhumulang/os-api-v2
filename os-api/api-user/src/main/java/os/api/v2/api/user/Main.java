package os.api.v2.api.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * os.api.v2.api.user
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 16:30
 */
@SpringBootApplication(scanBasePackages = "os.api.v2.api.user")
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan({
        "os.api.v2.api.user",
        "os.api.v2.common.auth.config",
        "os.api.v2.common.auth.handle",
})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}