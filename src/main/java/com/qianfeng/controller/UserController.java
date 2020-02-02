package com.qianfeng.controller;

import com.qianfeng.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 时间：  2020/2/1
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("/login")
    public String login(){
        System.out.println(" goto登录页面");

        return "login";
    }

    @PostMapping("/login")
    public  String loginlogic(User user){
        System.out.println("login logic ");
        //获取subject ，调用login
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
         //登录失败会抛出异常，会交给异常解析器处理
        subject.login(token);
        //登录成功，就跳转success
        return "success";
    }

    @GetMapping("/all")
    public  String queryall(){
        System.out.println("lqueryall ---------------- ");

        return "success";
    }

    @RequestMapping("/perms/error")
    public  String permission(){
        System.out.println("permission ---------------- ");

        return "error";
    }
}
