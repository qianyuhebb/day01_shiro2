package com.qianfeng.test;

import com.qianfeng.dao.PermissionDao;
import com.qianfeng.dao.RoleDao;
import com.qianfeng.dao.UserDao;
import com.qianfeng.pojo.Role;
import com.qianfeng.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 时间：  2020/2/2
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
public class TestUser {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        User user = userDao.queryUserByUsername("松松");
        System.out.println(user);


    }
    @Test
    public  void testUser(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        RoleDao roleDao = context.getBean("roleDao", RoleDao.class);
        PermissionDao permissionDao = context.getBean("permissionDao", PermissionDao.class);
        User user = userDao.queryUserByUsername("松松");
        String  role = String.valueOf(roleDao.queryRoleByUsername("松松"));
        String  perm = String.valueOf(permissionDao.queryPermsByusername("松松"));
        System.out.println(user);
        System.out.println(role);
        System.out.println(perm);
    }
}
