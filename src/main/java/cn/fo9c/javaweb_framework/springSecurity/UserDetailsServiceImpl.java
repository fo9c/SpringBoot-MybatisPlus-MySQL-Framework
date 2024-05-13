package cn.fo9c.javaweb_framework.springSecurity;

import cn.fo9c.javaweb_framework.domain.User.User;
import cn.fo9c.javaweb_framework.domain.User.UserLoginDetails;
import cn.fo9c.javaweb_framework.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 加载日志
        Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

        // 通过用户名查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getName, username);
        User user = userMapper.selectOne(queryWrapper);
        logger.info("查询到用户正在登陆：" + username);

        // 如果用户不存在，抛出异常
        if (Objects.isNull(user)) {
            logger.warn("用户：{}不存在 登陆失败", username);
            throw new RuntimeException("用户不存在");
        }

        // 把用户信息封装到UserLoginDetails中
        return new UserLoginDetails(user);

    }
}
