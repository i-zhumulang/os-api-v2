// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 23:52
// +----------------------------------------------------------------------
package os.api.v2.common.base.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.common.base.utils.ListToTree
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 23:52
 */
public class ListToTree<T> {

    // 流程：数据库查出的菜单记录装载在承载菜单的列表中---
    //         构建树（获取根节点，遍历根节点，对每一个根节点构建子树）---得到最终树形菜单

    // 承载菜单的列表
    private List<T> menuList = new ArrayList<>();

    // 带参构造器，将数据库中的菜单数据记录，装载在我们承载菜单的列表中
    public ListToTree(List<T> menuList) {
        this.menuList = menuList;
    }

    // 获取根节点
    public List<T> getRootNode() {
        List<T> rootNode = new ArrayList<>();
        for (T menu : menuList) {
            if (menu.getParentId().equals(0)) {
                rootNode.add(menu);
            }
        }
        return rootNode;
    }

    // 构建子树
    public T buildChildren(T rootNode) {
        List<T> childrenTree = new ArrayList<>();
        for (T menu : menuList) {
            if (menu.getParentId().equals(rootNode.getId())) {
                childrenTree.add(buildChildren(menu));
            }
        }
        rootNode.setChildren(childrenTree);
        return rootNode;
    }

    // 构建树
    public List<T> buildTree() {
        List<T> menus = getRootNode();
        for (T menu : menus) {
            buildChildren(menu);
        }
        return menus;
    }
}