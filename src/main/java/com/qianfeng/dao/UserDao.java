package com.qianfeng.dao;

import com.qianfeng.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 时间：  2020/2/2
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/

public interface UserDao {

     User queryUserByUsername(@Param("username") String username);

     Integer insertUser(User user);
}
