package com.pubsite.pubsite.repository;

import com.pubsite.pubsite.entity.Standards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StandardsRepository extends JpaRepository<Standards, Integer> {

    Standards findStandardsByUserId(Integer userId);

    Standards deleteStandardsByFirstNameAndLastName(String firstName, String lastName);

    Standards deleteStandardsByUserId(Integer userId);

    List<Standards> findByFirstNameAndLastName(String firstName, String lastName);

    List<Standards> findByFirstName(String firstName);

    List<Standards> findByLastName(String lastName);

    @Modifying
    @Query(value = "update standards set first_name=:first_name, last_name=:last_name where user_id=:user_id", nativeQuery = true)
    void update(@Param("first_name") String first_name, @Param("last_name") String last_name, @Param("user_id") Integer user_id);
}
