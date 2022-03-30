package com.lovelive.dto.user;

import com.lovelive.dto.role.RoleDto;
import com.lovelive.enums.Gender;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/19 10:02
 */
@Data
public class UserDto {

    /**
     * 用户ID
     */
    private String id;

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
     * 角色
     */
    private List<RoleDto> roles;

    /**
     * 性别
     */
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
}
