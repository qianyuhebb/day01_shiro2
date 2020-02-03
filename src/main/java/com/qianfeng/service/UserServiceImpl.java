package com.qianfeng.service;

import com.qianfeng.constant.MyConstant;
import com.qianfeng.dao.UserDao;
import com.qianfeng.pojo.User;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 时间：  2020/2/2
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserByUsername(String username) {

        User user = userDao.queryUserByUsername(username);

        return user;
    }

    @Override
    public Integer insertUser(User user) {
        //加密=加盐+迭代
        String salt =UUID.randomUUID().toString();
        String password =
                new Sha256Hash(user.getPassword(), salt, MyConstant.INTERCOUNT).toBase64();
        user.setPassword(password);
        user.setSalt(salt);
        return userDao.insertUser(user);
    }
}
