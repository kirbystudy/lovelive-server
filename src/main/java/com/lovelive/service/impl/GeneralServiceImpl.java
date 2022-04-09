package com.lovelive.service.impl;

import com.lovelive.dto.BaseDto;
import com.lovelive.entity.BaseEntity;
import com.lovelive.exception.BizException;
import com.lovelive.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author 小埋
 * @version 1.0
 * @Description 抽象公共方法实现父类
 * @Date 2022/4/9 10:38
 */
public abstract class GeneralServiceImpl<Entity extends BaseEntity, Dto extends BaseDto> implements GeneralService<Entity, Dto> {


    @Override
    public Dto create(Dto dto) {
        return getMapper().toDto(getRepository().save(getMapper().toEntity(dto)));
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
    @Transactional(rollbackFor = Exception.class)
    public Dto update(String id, Dto dto) {
        // Todo: dto 可能无法控制更新字段
        Entity existedEntity = getEntity(id);
        Entity updateEntity = getRepository().save(getMapper().updateEntity(existedEntity, dto));
        return getMapper().toDto(updateEntity);

    }

    @Override
    public void delete(String id) {
        Entity existedEntity = getEntity(id);
        getRepository().delete(existedEntity);
    }

    @Override
    public Page<Dto> search(Dto searchDto, Pageable pageable) {
        return null;
    }
}
