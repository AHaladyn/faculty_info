package com.pubsite.pubsite.repository;

import com.pubsite.pubsite.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer>{
}
