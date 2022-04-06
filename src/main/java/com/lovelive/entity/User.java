package com.lovelive.entity;

import com.lovelive.enums.Gender;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description 用户表(User)实体类
 * @Date 2022/3/18 20:01
 */
@Entity
@Data
public class User extends BaseEntity implements UserDetails {

    /**
     * 用户名
     */
    @Column(unique = true)
    private String username;

    /**
     * 用户昵称
     */
    @Column(unique = true)
    private String nickname;

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 性别
     */
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /**
     * 是否锁定，1-是，0-否
     */
    private Boolean locked = false;

    /**
     * 是否可用，1-是，0-否
     */
    private Boolean enabled = true;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 最后登录IP
     */
    private Date lastLoginTime;

    /**
     * 角色
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    /**
     * 返回授予用户的权限。无法返回 <code>null</code>。
     *
     * @return 权限，按自然键排序（从不 <code>null</code>）
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    /**
     * 指示用户的帐户是否已过期。过期的账户不能认证。
     *
     * @return <code>true</code> 如果用户的账号有效（即未过期），
     * <code>false</code> 如果不再有效（即过期）
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指示用户是被锁定还是解锁。锁定的用户不能认证。
     *
     * @return <code>true</code> 如果用户没有被锁定，<code>false</code> 否则
     */
    @Override
    public boolean isAccountNonLocked() {
        return !getLocked();
    }

    /**
     * 指示用户的凭据（密码）是否已过期。已到期凭据阻止身份验证。
     *
     * @return <code>true</code> 如果用户的凭据有效（即未过期），
     * <code>false</code> 如果不再有效（即过期）
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 指示用户是启用还是禁用。禁用的用户不能认证。
     *
     * @return <code>true</code> 如果用户启用，<code>false</code> 否则
     */
    @Override
    public boolean isEnabled() {
        return getEnabled();
    }
}

