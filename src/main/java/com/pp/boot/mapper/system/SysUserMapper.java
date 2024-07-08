package com.pp.boot.mapper.system;

import com.pp.boot.model.core.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface SysUserMapper {
//    int deleteByPrimaryKey(Long userId);
//
//    int insert(SysUser record);
//
//    int insertSelective(SysUser record);
//
//    SysUser selectByPrimaryKey(Long userId);
//
//    int updateByPrimaryKeySelective(SysUser record);
//
//    int updateByPrimaryKey(SysUser record);

    SysUser selectUserByUserName(String username);

    int updateUser(SysUser sysUser);
}