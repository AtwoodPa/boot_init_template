package com.pp.boot.mapper.system;

import com.pp.boot.model.core.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author panpan
* @description 针对表【sys_role(角色信息表)】的数据库操作Mapper
* @createDate 2024-07-07 20:33:25
* @Entity generator.domain.SysRole
*/
@Repository
public interface SysRoleMapper {

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 角色列表
     */
    List<SysRole> selectRolePermissionByUserId(Long userId);
}
