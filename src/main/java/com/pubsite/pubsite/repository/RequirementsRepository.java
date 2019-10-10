package com.pubsite.pubsite.repository;

import com.pubsite.pubsite.entity.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RequirementsRepository extends JpaRepository<Requirements, Integer> {

    @Modifying
    @Query(value = "update requirements set requirement=:requirement where id=:id", nativeQuery = true)
    void update(@Param("requirement") String requirement, @Param("id") Integer id);
}
