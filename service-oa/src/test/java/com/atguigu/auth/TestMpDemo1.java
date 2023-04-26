package com.atguigu.auth;

import com.atguigu.auth.mapper.SysRoleMapper;
import com.atguigu.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMpDemo1 {
    @Autowired
    private SysRoleMapper mapper;

    //查询所有
    @Test
    public void getAll() {
        List<SysRole> list = mapper.selectList(null);
        System.out.println(list);
    }

    //添加属性
    @Test
    public void add() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("员工管理员");
        sysRole.setRoleCode("com");

        int rows = mapper.insert(sysRole);
        System.out.println(rows);
    }

    //修改操作
    @Test
    public void update() {
        //根据id查询
        SysRole sysRole = mapper.selectById(11);
        //设置修改值
        sysRole.setRoleName("atguigu角色管理员");
        //调用方法实现最终修改
        int rows = mapper.updateById(sysRole);
        System.out.println(rows);
    }
    //删除操作
    @Test
    public void deleteId(){
        int rows = mapper.deleteById(12);
    }
}
