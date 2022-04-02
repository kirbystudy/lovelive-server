package com.lovelive.vo.role;

import com.lovelive.vo.BaseVo;
import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/18 22:20
 */
@Data
public class RoleVo extends BaseVo {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色标识
     */
    private String title;
}
