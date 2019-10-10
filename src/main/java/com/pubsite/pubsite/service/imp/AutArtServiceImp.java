package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.entity.AutArt;
import com.pubsite.pubsite.repository.AutArtRepository;
import com.pubsite.pubsite.service.AutArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class AutArtServiceImp implements AutArtService {

    @Autowired
    private AutArtRepository autArtRepository;

    @Autowired
    private AutArtServiceImp(AutArtRepository autArtRepository) {
        this.autArtRepository = autArtRepository;
    }


    @Override
    public List<AutArt> autartList() {
        return autArtRepository.findAll();
    }

    @Override
    public Optional<AutArt> findOne(Integer id) {
        return autArtRepository.findById(id);
    }

    @Override
    public void addAutArt(AutArt autArt) {
        this.autArtRepository.save(autArt);
    }

    @Override
    public void deleteAutArt(Integer id) {
        autArtRepository.deleteById(id);
        System.out.println("{'message':'Article deleted'}");
    }

//    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    @Autowired
//    public void setNamedParameterJdbcTemplate(
//            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//    }
//
//    private SqlParameterSource getSqlParameterByModel(AutArt autArt) {
//
//        MapSqlParameterSource paramSource = new MapSqlParameterSource();
//        paramSource.addValue("title", autArt.getTitle());
//        paramSource.addValue("content", autArt.getContent());
//        paramSource.addValue("finished", autArt.isFinished());
//        paramSource.addValue("rejected", autArt.isRejected());
//        return paramSource;
//    }

    @Override
    public void update(AutArt autArt) {
//        String sql = "UPDATE AUTART SET TITLE=:title, CONTENT=:content, FINISHED=:finished, REJECTED=:rejected where id=" + autArt.getId();
//        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(autArt));

    }

//    @Override
//    public void upupdate(String title, String content, Timestamp written, boolean finished, boolean rejected, String whyreject, Integer author_id, Integer id) {
//        autArtRepository.upupdate(title, content, written, finished, rejected, whyreject, author_id, id);
//    }

    @Override
    public void save(AutArt autArt) {
        autArtRepository.saveAndFlush(autArt);
    }



}
