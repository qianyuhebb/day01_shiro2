package com.qianfeng.service;

import com.qianfeng.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * 时间：  2020/2/2
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/

public interface UserService {

     User queryUserByUsername(@Param("username") String username);
}
