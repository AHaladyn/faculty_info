package com.pubsite.pubsite.repository;

import com.pubsite.pubsite.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<Authors, Integer> {

    Authors findAuthorsByUserId(Integer userId);

    Authors deleteAuthorsByFirstNameAndLastName(String firstName, String lastName);

    Authors deleteAuthorsByUserId(Integer userId);

    List<Authors> findByFirstNameAndLastName(String firstName, String lastName);

    List<Authors> findByFirstName(String firstName);

    List<Authors> findByLastName(String lastName);

    @Modifying
    @Query(value = "update authors set first_name=:first_name, last_name=:last_name where user_id=:user_id", nativeQuery = true)
    void update(@Param("first_name") String first_name, @Param("last_name") String last_name, @Param("user_id") Integer user_id);
}
