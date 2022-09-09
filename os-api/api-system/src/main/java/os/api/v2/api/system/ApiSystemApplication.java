// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-07 17:50
// +----------------------------------------------------------------------
package os.api.v2.api.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import os.api.v2.common.base.utils.IdWorkerUtils;

/**
 * os.api.v2.api.system.ApiSystemApplication
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-07 17:50
 */
@SpringBootApplication(scanBasePackages = "os.api.v2.api.system")
@ComponentScan({
        "os.api.v2.api.system",
        "os.api.v2.common.auth.config",
        "os.api.v2.common.auth.handle",
})
public class ApiSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiSystemApplication.class, args);
    }
}
