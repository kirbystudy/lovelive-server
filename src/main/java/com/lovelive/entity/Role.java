package com.lovelive.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;
import java.io.Serializable;

/**
 * @author 太好听了吧
 * @version 1.0
 * @Description 角色表(Role)实体类
 * @Date 2022-03-18 21:27:40
 */
@Entity
@Data
public class Role extends AbstractEntity {

    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色标识
     */
    private String title;

}

