package cn.zyt.service.impl;

import cn.zyt.entity.User;
import cn.zyt.mapper.UserMapper;
import cn.zyt.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService
{
    @Resource
    UserMapper userMapper;

    @Override
    public User login(User user)
    {
        return userMapper.getUser(user);
    }
}
