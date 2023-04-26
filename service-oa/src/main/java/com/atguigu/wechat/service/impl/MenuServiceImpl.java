package com.atguigu.wechat.service.impl;

import com.atguigu.model.wechat.Menu;
import com.atguigu.vo.wechat.MenuVo;
import com.atguigu.wechat.mapper.MenuMapper;
import com.atguigu.wechat.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2023-04-26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public List<MenuVo> findMenuInfo() {
        List<MenuVo> list = new ArrayList<>();
        //1.查询所有菜单list集合
        List<Menu> menuList = baseMapper.selectList(null);
        //2.查询所有菜单中的一级菜单 parent_id=0,返回list集合
        List<Menu> oneMenuList = menuList.stream().filter(menu -> menu.getParentId().longValue() == 0).collect(Collectors.toList());
        //3.一级菜单list集合遍历,得到每个一级菜单
        for (Menu oneMenu : oneMenuList) {
            //一级菜单Menu -- MenuVo
            MenuVo oneMenuVo = new MenuVo();
            BeanUtils.copyProperties(oneMenu, oneMenuVo);
            //4.获取每个以及菜单中的二级菜单 id 和 parent_id
            List<Menu> twoMenuList = menuList.stream().filter(menu -> menu.getParentId().longValue() == oneMenu.getId()).collect(Collectors.toList());
            //5.把一级中获取的二级菜单封装到一级菜单的children中
            //List<Menu> -- list<MenuVo>
            List<MenuVo> children = new ArrayList<>();
            for (Menu twoMenu : twoMenuList) {
                MenuVo twoMenuVo = new MenuVo();
                BeanUtils.copyProperties(twoMenu, twoMenuVo);
                children.add(twoMenuVo);
            }
            oneMenuVo.setChildren(children);
            //把每个封装好的一级菜单放到最终的list集合
            list.add(oneMenuVo);
        }
        return list;
    }
}
