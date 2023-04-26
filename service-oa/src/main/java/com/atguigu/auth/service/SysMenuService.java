package com.atguigu.auth.service;


import com.atguigu.model.system.SysMenu;
import com.atguigu.vo.system.AssginMenuVo;
import com.atguigu.vo.system.RouterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-04-10
 */
public interface SysMenuService extends IService<SysMenu> {
    //菜单列表
    List<SysMenu> findNodes();
    //删除菜单
    void removeMenuById(Long id);
    //查询所有菜单和角色分配的菜单
    List<SysMenu> findMenuByRoleId(Long roleId);
    //进行角色分配菜单
    void doAssign(AssginMenuVo assginMenuVo);

    List<RouterVo> findUserMenuListByUserId(Long userId);

    List<String> findUserPermsByUserId(Long userId);
}
