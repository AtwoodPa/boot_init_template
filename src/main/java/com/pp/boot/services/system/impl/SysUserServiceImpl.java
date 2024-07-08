package com.pp.boot.services.system.impl;

import com.pp.boot.mapper.system.SysUserMapper;
import com.pp.boot.model.core.SysUser;
import com.pp.boot.services.system.SysUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author panpan
 * @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
 * @createDate 2024-07-07 20:33:25
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    private final SysUserMapper userMapper;

    /**
     * 查询用户信息 - SpringSecurity => loadUserByUsername
     * @param username
     * @return
     */
    @Override
    public SysUser selectUserByUserName(String username) {
         log.info("查询用户信息 - SpringSecurity => loadUserByUsername");
        return userMapper.selectUserByUserName(username);
    }

    /**
     * 修改用户基本信息
     * @param sysUser
     * @return
     */
    @Override
    public int updateUserProfile(SysUser sysUser) {
        return userMapper.updateUser(sysUser);
    }
}
