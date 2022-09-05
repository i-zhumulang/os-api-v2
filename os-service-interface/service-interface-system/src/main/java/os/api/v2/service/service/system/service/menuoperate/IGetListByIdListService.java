// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 22:41
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.service.menuoperate;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.service.service.system.service.menuoperate.IGetListByIdListService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 22:41
 */
public interface IGetListByIdListService {
    List<Map<String, Object>> getTableHeadListByIdList(List<Long> idList);
    List<Map<String, Object>> getTableBodyListByIdList(List<Long> idList);
}
