package com.danang.travel.converter;


import com.danang.travel.converter.bases.Converter;
import com.danang.travel.models.dao.User;
import com.danang.travel.models.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDaoToUserDtoConverter extends Converter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
}
