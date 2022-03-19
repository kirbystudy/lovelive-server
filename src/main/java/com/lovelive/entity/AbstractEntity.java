package com.lovelive.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author 太好听了吧
 * @version 1.0
 * @Description 相关实体类成员公共父类
 * @Date 2022/3/18 20:15
 */
@MappedSuperclass
@Data
public abstract class AbstractEntity {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(generator = "ksuid")
    @GenericGenerator(name = "ksuid", strategy = "com.lovelive.utils.KsuidIdentifierGenerator")
    private String id;

    /**
     * 创建时间
     */
    @CreationTimestamp
    private Date createdTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    private Date updatedTime;
}
