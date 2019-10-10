package com.pubsite.pubsite.service;

import com.pubsite.pubsite.entity.Authors;

import java.util.List;

public interface AuthorsService {

    public Authors findAuthorsByUserId(Integer userId);

    public void delete(Authors authors);

    public void add(Authors authors);

    void save(Authors authors);

    void update(String first_name, String last_name, Integer user_id);

    List<Authors> findByFirstNameAndLastName(String firstName, String lastName);

    List<Authors> findByFirstName(String firstName);

    List<Authors> findByLastName(String lastName);
}
