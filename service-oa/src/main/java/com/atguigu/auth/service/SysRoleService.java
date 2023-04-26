package com.atguigu.auth.service;

import com.atguigu.model.system.SysRole;
import com.atguigu.vo.system.AssginRoleVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface SysRoleService extends IService<SysRole> {
    //1.查询所有角色和当前所属角色
    Map<String, Object> findRoleDataByUserId(Long userId);
    //2.为用户分配角色
    void doAssign(AssginRoleVo assginRoleVo);
}
