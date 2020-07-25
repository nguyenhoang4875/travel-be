package com.danang.travel.services;

import com.danang.travel.models.dao.User;
import com.danang.travel.models.dto.Login;
import com.danang.travel.models.dto.UserDetailDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<?> login(Login login);


    User findOneByUsername(String username);


    User getCurrentUser();

    List<UserDetailDto> getAllUsers();

}
