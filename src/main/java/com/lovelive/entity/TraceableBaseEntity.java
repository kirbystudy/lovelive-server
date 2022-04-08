package com.lovelive.entity;

import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/5 17:37
 */
@Data
@MappedSuperclass
public class TraceableBaseEntity extends BaseEntity {

    /**
     * 创建者用户ID
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id")
    protected User createdBy;

    /**
     * 更新者用户ID
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by_user_id")
    protected User updatedBy;


}
