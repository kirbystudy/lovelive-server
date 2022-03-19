package com.lovelive.entity;

import com.lovelive.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 太好听了吧
 * @version 1.0
 * @Description 用户表(User)实体类
 * @Date 2022/3/18 20:01
 */
@Entity
@Data
public class User extends AbstractEntity {

    /**
     * 用户名
     */
    @Column(unique = true)
    private String username;

    /**
     * 用户昵称
     */
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
    private Boolean locked;

    /**
     * 是否可用，1-是，0-否
     */
    private Boolean enabled;

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
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<Role> roles;
}

