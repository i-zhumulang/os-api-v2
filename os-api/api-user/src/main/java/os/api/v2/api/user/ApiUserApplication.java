// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-01 22:27
// +----------------------------------------------------------------------
package os.api.v2.api.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * os.api.v2.api.user.ApiUserApplication
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-01 22:27
 */
@SpringBootApplication(scanBasePackages = "os.api.v2.api.user")
@EnableDiscoveryClient
@ComponentScan({
        "os.api.v2.api.user",
        "os.api.v2.common.auth.handle",
})
public class ApiUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiUserApplication.class, args);
    }
}
