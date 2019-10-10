package com.pubsite.pubsite.repository;

import com.pubsite.pubsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    List<User> findAllByUsername(String username);

    User findById(long id);

    User deleteUserByUsername(String username);

    User deleteUserById(Integer id);

    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);

    List<User> findAllByUsernameIsStartingWith(String username);

    Optional<User> findByResetToken(String resetToken);
}
