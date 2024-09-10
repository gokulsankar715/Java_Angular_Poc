package com.bosch.user.mapper;

import com.bosch.user.dto.UserDto;
import com.bosch.user.entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-12T16:19:35+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Red Hat, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public List<UserDto> toDtoList(List<Users> userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userEntity.size() );
        for ( Users users : userEntity ) {
            list.add( toDto( users ) );
        }

        return list;
    }

    @Override
    public UserDto toDto(Users users) {
        if ( users == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( users.getId() );
        userDto.userName( users.getUserName() );
        userDto.userAddress( users.getUserAddress() );
        userDto.userMobileNo( users.getUserMobileNo() );
        userDto.userEmailId( users.getUserEmailId() );

        return userDto.build();
    }

    @Override
    public Users toEntity(UserDto userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( userEntity.getId() );
        users.setUserName( userEntity.getUserName() );
        users.setUserAddress( userEntity.getUserAddress() );
        users.setUserMobileNo( userEntity.getUserMobileNo() );
        users.setUserEmailId( userEntity.getUserEmailId() );

        return users;
    }
}
