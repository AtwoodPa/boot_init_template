package com.pp.boot.services.system;

import com.pp.boot.model.core.SysUser;

/**
* @author panpan
* @description 针对表【sys_user(用户信息表)】的数据库操作Service
* @createDate 2024-07-07 20:33:25
*/
public interface SysUserService {

    public SysUser selectUserByUserName(String username);

    public int updateUserProfile(SysUser sysUser);
}
