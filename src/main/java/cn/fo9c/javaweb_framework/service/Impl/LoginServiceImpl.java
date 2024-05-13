package cn.fo9c.javaweb_framework.service.Impl;

import cn.fo9c.javaweb_framework.domain.User.UserDTO;
import cn.fo9c.javaweb_framework.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(UserDTO userDTO) {
        // AuthenticationManager authenticate进行认证


        // 认证未通过，返回错误信息

        // 认证通过，返回JWTToken并返回给前端

        return null;
    }


}
