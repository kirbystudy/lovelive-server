package com.lovelive.mapper;

import com.lovelive.dto.UserDto;
import com.lovelive.entity.User;
import com.lovelive.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author 太好听了吧
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/19 10:15
 */
@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);
}
