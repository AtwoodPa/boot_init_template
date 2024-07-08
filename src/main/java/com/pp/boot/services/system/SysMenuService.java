package com.pp.boot.services.system;

import java.util.Collection;
import java.util.Set;

/**
* @author panpan
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service
* @createDate 2024-07-07 20:33:25
*/
public interface SysMenuService{

    /**
     * 根据角色ID查询权限
     *
     * @param roleId 角色ID
     * @return 权限列表
     */
    public Set<String> selectMenuPermsByRoleId(Long roleId);

    Set<String> selectMenuPermsByUserId(Long userId);
}
