package com.lovelive.dto;

import com.lovelive.dto.user.UserDto;
import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/11 12:18
 */
@Data
public class TraceableBaseDto extends BaseDto {

    private UserDto createdBy;

    private UserDto updatedBy;
}
