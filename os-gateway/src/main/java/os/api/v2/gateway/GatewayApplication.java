// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-01 21:34
// +----------------------------------------------------------------------
package os.api.v2.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * os.api.v2.gateway.GatewayApplication
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-01 21:34
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({
        "os.api.v2.gateway",
        "os.api.v2.common.base.handle",
})
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
