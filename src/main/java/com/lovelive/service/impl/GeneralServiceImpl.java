package com.lovelive.service.impl;

import com.lovelive.dto.BaseDto;
import com.lovelive.entity.BaseEntity;
import com.lovelive.exception.BizException;
import com.lovelive.service.GeneralService;

import java.util.Optional;

/**
 * @author 小埋
 * @version 1.0
 * @Description 抽象公共方法实现父类
 * @Date 2022/4/9 10:38
 */
public abstract class GeneralServiceImpl<Entity extends BaseEntity, Dto extends BaseDto> extends BaseService implements GeneralService<Entity, Dto> {

    @Override
    public Dto create(Dto dto) {
        Entity entity = getMapper().toEntity(dto);
        return getMapper().toDto(getRepository().save(entity));
    }

    @Override
    public Dto update(String id, Dto dto) {
        Entity existedEntity = getEntity(id);
        Entity updatedEntity = getRepository().save(getMapper().updateEntity(existedEntity, dto));
        return getMapper().toDto(updatedEntity);
    }

    @Override
    public Dto get(String id) {
        return getMapper().toDto(getEntity(id));
    }

    protected Entity getEntity(String id) {
        Optional<Entity> optionalEntity = getRepository().findById(id);
        if (!optionalEntity.isPresent()) {
            throw new BizException(getNotFoundExceptionType());
        }
        return optionalEntity.get();
    }


    @Override
    public void delete(String id) {
        Entity existedEntity = getEntity(id);
        getRepository().delete(existedEntity);
    }

}
