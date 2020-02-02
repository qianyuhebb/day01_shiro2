package com.qianfeng.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * 时间：  2020/2/1
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
public class TestShiro {

    public static void main(String[] args) {

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager =factory.getInstance();

        //将securityManager（核心控制者）  交给SecurityUtils 管理  直接和SecurityUtils打交道
        SecurityUtils.setSecurityManager(securityManager);
         //客户端直接和subject 打交道   subject  可以shiro的相关功能
        Subject subject = SecurityUtils.getSubject();



        System.out.println(subject.isAuthenticated());

        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
        System.out.println(token.getUsername()+"=="+token.getPassword());

        subject.login(token);

        System.out.println(subject.getPrincipal());

        System.out.println(subject.isAuthenticated());
        System.out.println(subject.hasRole("admin"));
        System.out.println(subject.isPermitted("user:query"));
         subject.logout();
        System.out.println("----");
        System.out.println(subject.isAuthenticated());
        System.out.println(subject.hasRole("admin"));
        System.out.println(subject.isPermitted("user:query"));
    }
}
