package com.lovelive.vo;

import com.lovelive.entity.Role;
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
     * 角色
     */
    private List<RoleVo> roles;
}
