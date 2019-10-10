package com.pubsite.pubsite.repository;

import com.pubsite.pubsite.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminsRepository extends JpaRepository<Admins, Integer> {

    Admins findAdminsByUserId(Integer userId);

    Admins deleteAdminsByFirstNameAndLastName(String firstName, String lastName);

    Admins deleteAdminsByUserId(Integer userId);

    List<Admins> findByFirstNameAndLastName(String firstName, String lastName);

    List<Admins> findByFirstName(String firstName);

    List<Admins> findByLastName(String lastName);

    @Modifying
    @Query(value = "update admins set first_name=:first_name, last_name=:last_name where user_id=:user_id", nativeQuery = true)
    void update(@Param("first_name") String first_name, @Param("last_name") String last_name, @Param("user_id") Integer user_id);
}
