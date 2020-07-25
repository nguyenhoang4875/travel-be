package com.danang.travel.converter;


import com.danang.travel.converter.bases.Converter;
import com.danang.travel.models.dao.User;
import com.danang.travel.models.dto.UserDetailDto;
import org.springframework.stereotype.Component;

@Component
public class UserDaoToUserDetailDtoConverter extends Converter<User, UserDetailDto> {

    @Override
    public UserDetailDto convert(User source) {
        UserDetailDto userDetailDto = new UserDetailDto();
        userDetailDto.setId(source.getId());
        userDetailDto.setUsername(source.getUsername());
        userDetailDto.setFirstName(source.getFirstName());
        userDetailDto.setLastName(source.getLastName());
        userDetailDto.setEmail(source.getEmail());
        userDetailDto.setEnabled(source.isEnabled());
        userDetailDto.setAvatar(source.getAvatar());
        return userDetailDto;
    }
}
