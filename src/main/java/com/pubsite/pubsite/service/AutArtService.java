package com.pubsite.pubsite.service;

import com.pubsite.pubsite.entity.AutArt;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface AutArtService {

    List<AutArt> autartList();

    Optional<AutArt> findOne(Integer id);

    void addAutArt(AutArt autArt);

    void deleteAutArt(Integer id);

    void update(AutArt autArt);

    //void upupdate(String title, String content, Timestamp written, boolean finished, boolean rejected, String whyreject, Integer author_id, Integer id);

    void save(AutArt autArt);
}
