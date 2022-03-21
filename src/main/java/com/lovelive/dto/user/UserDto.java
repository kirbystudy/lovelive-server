package com.lovelive.dto.user;

import com.lovelive.vo.RoleVo;
import lombok.Data;

import javax.persistence.Column;
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
    private List<RoleVo> roles;
}
