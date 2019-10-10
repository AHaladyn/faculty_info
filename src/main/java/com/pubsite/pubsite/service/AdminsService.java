package com.pubsite.pubsite.service;

import com.pubsite.pubsite.entity.Admins;

import java.util.List;

public interface AdminsService {

    public Admins findAdminsByUserId(Integer userId);

    public void delete(Admins admins);

    public void add(Admins admins);

    void save(Admins admins);

    void update(String first_name, String last_name, Integer user_id);

    List<Admins> findByFirstNameAndLastName(String firstName, String lastName);

    List<Admins> findByFirstName(String firstName);

    List<Admins> findByLastName(String lastName);

}
