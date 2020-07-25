package com.danang.travel.services;


import com.danang.travel.models.dao.Role;

public interface RoleService {
    Role findOneByName(String name);
}
