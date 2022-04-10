package com.lovelive.service;

import com.lovelive.dto.BaseDto;
import com.lovelive.entity.BaseEntity;
import com.lovelive.enums.ExceptionType;
import com.lovelive.mapper.MapperInterface;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/9 10:26
 */
public interface GeneralService<Entity extends BaseEntity, Dto extends BaseDto> {

    JpaRepository<Entity, String> getRepository();

    MapperInterface<Entity, Dto> getMapper();

    ExceptionType getNotFoundExceptionType();

    Dto create(Dto dto);

    Dto get(String id);

    Dto update(String id, Dto dto);

    void delete(String id);

}
