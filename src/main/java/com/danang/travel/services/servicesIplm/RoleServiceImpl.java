package com.danang.travel.services.servicesIplm;

import com.danang.travel.models.dao.Role;
import com.danang.travel.repositories.RoleRepository;
import com.danang.travel.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findOneByName(String name) {
        return roleRepository.findByName(name);
    }
}
