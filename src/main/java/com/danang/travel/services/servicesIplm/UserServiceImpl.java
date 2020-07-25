package com.danang.travel.services.servicesIplm;


import com.danang.travel.configurations.TokenProvider;
import com.danang.travel.converter.bases.Converter;
import com.danang.travel.models.dao.User;
import com.danang.travel.models.dto.Login;
import com.danang.travel.models.dto.UserDetailDto;
import com.danang.travel.models.dto.UserDto;
import com.danang.travel.repositories.UserRepository;
import com.danang.travel.services.RoleService;
import com.danang.travel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private Converter<User, UserDto> userDaoToUserDtoConverter;

    @Autowired
    private Converter<User, UserDetailDto> userDaoToUserDetailDtoConverter;


    @Override
    public List<UserDetailDto> getAllUsers() {
        return userDaoToUserDetailDtoConverter.convert(userRepository.findAll());
    }


    @Override
    @Transactional
    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public ResponseEntity<?> login(Login login) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getUsername(),
                        login.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(authentication);
        UserDto userDto = userDaoToUserDtoConverter.convert(userService.findOneByUsername(login.getUsername()));
        userDto.setExpired(tokenProvider.getExpirationDateFromToken(token));
        userDto.setToken(token);
        return ResponseEntity.ok(userDto);
    }


}

