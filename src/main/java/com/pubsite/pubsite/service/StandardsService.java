package com.pubsite.pubsite.service;

import com.pubsite.pubsite.entity.Standards;

import java.util.List;

public interface StandardsService {
    public Standards findStandardsByUserId(Integer userId);

    public void delete(Standards standards);

    public void add(Standards standards);

    void save(Standards standards);

    void update(String first_name, String last_name, Integer user_id);

    List<Standards> findByFirstNameAndLastName(String firstName, String lastName);

    List<Standards> findByFirstName(String firstName);

    List<Standards> findByLastName(String lastName);
}
