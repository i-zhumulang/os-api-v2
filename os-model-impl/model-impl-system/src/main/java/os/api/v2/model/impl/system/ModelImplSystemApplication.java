// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-03 00:31
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * os.api.v2.model.impl.system.ModelImplSystemApplication
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-03 00:31
 */
@SpringBootApplication(scanBasePackages = "os.api.v2.model.impl.system")
@MapperScan(value = "os.api.v2.model.impl.system.mapper")
@EnableDiscoveryClient
public class ModelImplSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ModelImplSystemApplication.class, args);
    }
}
