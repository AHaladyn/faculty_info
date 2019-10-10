package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.entity.Role;
import com.pubsite.pubsite.repository.RoleRepository;
import com.pubsite.pubsite.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("roleService")
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleRepository roleRepository;


    @Override
    public void add(Role role) {
        role.setName(role.getName());
        role.setId(role.getId());

        roleRepository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role findById(Integer id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent())
            return role.get();
        else
            return null;
    }
}
