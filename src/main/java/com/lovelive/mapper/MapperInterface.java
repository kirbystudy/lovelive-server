package com.lovelive.mapper;

import com.lovelive.dto.BaseDto;
import com.lovelive.entity.BaseEntity;
import org.mapstruct.MappingTarget;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/9 10:47
 */
public interface MapperInterface<Entity extends BaseEntity, Dto extends BaseDto> {

    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    Entity updateEntity(@MappingTarget Entity entity, Dto dto);

}
