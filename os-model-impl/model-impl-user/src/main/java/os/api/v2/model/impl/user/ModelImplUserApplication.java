// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 01:11
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * os.api.v2.model.impl.user.ModelImplUserApplication
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 01:11
 */
@SpringBootApplication(scanBasePackages = "os.api.v2.model.impl.user")
@MapperScan(value = "os.api.v2.model.impl.user.mapper")
@EnableDiscoveryClient
@EnableAutoConfiguration
public class ModelImplUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelImplUserApplication.class, args);
    }
}
