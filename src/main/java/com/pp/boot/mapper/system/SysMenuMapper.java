package com.pp.boot.mapper.system;


import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author panpan
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Mapper
* @createDate 2024-07-07 20:33:25
* @Entity generator.domain.SysMenu
*/
@Repository
public interface SysMenuMapper  {


    /**
     * 根据角色ID查询权限
     *
     * @param roleId 角色ID
     * @return 权限列表
     */
    public List<String> selectMenuPermsByRoleId(Long roleId);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectMenuPermsByUserId(Long userId);
}
