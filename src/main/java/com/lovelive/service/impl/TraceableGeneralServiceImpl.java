package com.lovelive.service.impl;

import com.lovelive.dto.BaseDto;
import com.lovelive.entity.TraceableBaseEntity;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/11 11:53
 */
abstract class TraceableGeneralServiceImpl<Entity extends TraceableBaseEntity, Dto extends BaseDto> extends GeneralServiceImpl<Entity, Dto> {

    @Override
    public Dto create(Dto dto) {
        Entity entity = getMapper().toEntity(dto);
        entity.setCreatedBy(getCurrentUserEntity());
        entity.setUpdatedBy(getCurrentUserEntity());
        return getMapper().toDto(getRepository().save(entity));
    }

    @Override
    public Dto update(String id, Dto dto) {
        Entity existedEntity = getEntity(id);
        Entity entity = getMapper().updateEntity(existedEntity, dto);
        entity.setUpdatedBy(getCurrentUserEntity());
        Entity updateEntity = getRepository().save(entity);
        return getMapper().toDto(updateEntity);

    }

}
