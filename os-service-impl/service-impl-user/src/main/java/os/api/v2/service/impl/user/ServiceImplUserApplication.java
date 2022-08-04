// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-04 21:41
// +----------------------------------------------------------------------
package os.api.v2.service.impl.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * os.api.v2.service.impl.user.ServiceImplUserApplication
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-04 21:41
 */
@SpringBootApplication(scanBasePackages = "os.api.v2.service.impl.user")
@EnableDiscoveryClient
public class ServiceImplUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceImplUserApplication.class, args);
    }
}
