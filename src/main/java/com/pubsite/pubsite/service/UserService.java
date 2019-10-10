package com.pubsite.pubsite.service;

import com.pubsite.pubsite.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findByUsername(String username);

    List<User> findAllByUsername(String username);

    Optional<User> findUserByEmail(String email);

    Optional findUserById(Integer id);

    void save(User user);

    void saveReg(User user);

    void add(User user);

    void delete(User user);

    void update(User user);

    void addNewUser(User user);

    User findCurrentLoggedUser();

    List<User> findAllUserByPartName(String name);

    Optional<User> findUserByResetToken(String resetToken);

    List<User> userList();
}
