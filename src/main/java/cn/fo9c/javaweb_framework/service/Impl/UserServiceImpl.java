package cn.fo9c.javaweb_framework.service.Impl;

import cn.fo9c.javaweb_framework.mapper.UserMapper;
import cn.fo9c.javaweb_framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
}
