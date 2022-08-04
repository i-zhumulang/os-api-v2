// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-04 21:43
// +----------------------------------------------------------------------
package os.api.v2.service.impl.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * os.api.v2.service.impl.system.ServiceImplSystemApplication
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-04 21:43
 */
@SpringBootApplication(scanBasePackages = "os.api.v2.service.impl.system")
@EnableDiscoveryClient
public class ServiceImplSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceImplSystemApplication.class, args);
    }
}
