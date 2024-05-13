package cn.fo9c.javaweb_framework.conrtoller;

import cn.fo9c.javaweb_framework.domain.User.UserDTO;
import cn.fo9c.javaweb_framework.service.Impl.LoginServiceImpl;
import cn.fo9c.javaweb_framework.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/user")
    public ResponseResult<String> login(@RequestBody UserDTO userDTO) {
        loginService.login(userDTO);
        return ResponseResult.success("登录成功", "登录成功");
    }
}
