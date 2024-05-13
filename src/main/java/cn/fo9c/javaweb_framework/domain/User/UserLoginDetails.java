package cn.fo9c.javaweb_framework.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// 使用Lombok注解简化代码
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDetails implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /**
     * 获取密码
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * 获取用户名
     */
    @Override
    public String getUsername() {
        return user.getName();
    }

    /**
     * 账号是否未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        // TODO
        return true;
    }

    /**
     * 账号是否未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        // TODO
        return true;
    }

    /**
     * 凭证是否未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO
        return true;
    }

    /**
     * 账号是否可用
     */
    @Override
    public boolean isEnabled() {
        // TODO
        return true;
    }
}
