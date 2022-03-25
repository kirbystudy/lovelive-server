package com.lovelive.mapper;

import com.lovelive.dto.user.UserCreateRequest;
import com.lovelive.dto.user.UserDto;
import com.lovelive.dto.user.UserUpdateRequest;
import com.lovelive.entity.User;
import com.lovelive.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/19 10:15
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * toDto 用来接收前端传过来的值
     * @param user
     * @return
     */
    UserDto toDto(User user);

    /**
     * toVo 用来和前端传输数据
     * @param userDto
     * @return
     */
    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
