package com.pubsite.pubsite.service;

import com.pubsite.pubsite.entity.Role;

public interface RoleService {
    void add(Role role);

    Role findByName(String name);

    Role findById(Integer Id);
}
