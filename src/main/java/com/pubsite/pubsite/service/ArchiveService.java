package com.pubsite.pubsite.service;

import com.pubsite.pubsite.entity.Archive;

import java.util.List;
import java.util.Optional;

public interface ArchiveService {
    List<Archive> archiveList();

    Optional<Archive> findOne(Integer id);

    void addArchive(Archive archive);

    void deleteArchive(Integer id);
}
