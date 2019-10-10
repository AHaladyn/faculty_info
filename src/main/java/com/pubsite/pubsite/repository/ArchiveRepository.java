package com.pubsite.pubsite.repository;

import com.pubsite.pubsite.entity.Archive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Integer> {
}
