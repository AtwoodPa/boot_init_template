package com.pp.boot.services.system;

import java.util.Collection;
import java.util.Set;

/**
* @author panpan
* @description 针对表【sys_role(角色信息表)】的数据库操作Service
* @createDate 2024-07-07 20:33:25
*/
public interface SysRoleService {

    /**
     * 根据用户ID查询角色权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectRolePermissionByUserId(Long userId);

}
