package com.qianfeng.controller;

import org.apache.shiro.authz.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 时间：  2020/2/4
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
@RequestMapping("/order")
@Controller

public class OrderController {

    @RequiresUser
    @RequestMapping("/query")
    public String query(){
        System.out.println("query page");
        return "success";
    }

    @RequiresAuthentication
    @RequiresRoles(value = {"banzhang","student"},logical = Logical.OR)
    @RequestMapping("/save")
    public String save(){
        System.out.println("save page");
        return "success";
    }


    @RequiresAuthentication
//    @RequiresPermissions("student:study")
   @RequiresPermissions(value = {"student:yq","student:study"})
    @RequestMapping("/delete")
    public String delete(){
        System.out.println("delete page");
        return "success";
    }


    @RequiresAuthentication
    @RequestMapping("/update")
    public String update(){
        System.out.println("update page");
        return "success";
    }
}
