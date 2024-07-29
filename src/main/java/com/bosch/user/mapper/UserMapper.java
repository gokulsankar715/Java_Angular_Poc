package com.bosch.user.mapper;

import com.bosch.user.dto.UserDto;
import com.bosch.user.entity.Users;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  List<UserDto> toDtoList(List<Users> userEntity);

  UserDto toDto(Users users);

  Users toEntity(UserDto userEntity);
}
