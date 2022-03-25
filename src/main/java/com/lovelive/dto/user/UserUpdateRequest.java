package com.lovelive.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/25 14:36
 */
@Data
public class UserUpdateRequest {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 4,max = 64,message = "用户名长度应该在4个字符到64个字符之间")
    private String username;

    private String nickname;

    private String gender;
}
