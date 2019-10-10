package com.pubsite.pubsite.repository;

import com.pubsite.pubsite.entity.AutArt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface AutArtRepository extends JpaRepository<AutArt, Integer> {
//
//    @Modifying
//    @Query(value = "update autart set title=:title, content=:content, written=:written, finished=:finished, rejected=:rejected, whyreject=:whyreject, author_id=:author_id where id=:id", nativeQuery = true)
//    void upupdate(@Param("title") String title,
//                  @Param("content") String content,
//                  @Param("written") Timestamp written,
//                  @Param("finished") boolean finished,
//                  @Param("rejected") boolean rejected,
//                  @Param("whyreject") String whyreject,
//                  @Param("author_id") Integer author_id,
//                  @Param("id") Integer id);

}
