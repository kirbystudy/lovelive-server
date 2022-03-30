package com.lovelive.vo.user;

import com.lovelive.enums.Gender;
import com.lovelive.vo.role.RoleVo;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/18 22:17
 */
@Data
public class UserVo {

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
     * 性别
     */
    private Gender gender;

    /**
     * 角色
     */
    private List<RoleVo> roles;

    /**
     * 是否锁定，1-是，0-否
     */
    private Boolean locked;

    /**
     * 是否可用，1-是，0-否
     */
    private Boolean enabled;
}
