package com.pubsite.pubsite.service;

import com.pubsite.pubsite.entity.Requirements;

import java.util.List;
import java.util.Optional;

public interface RequirementsService {

    public void add(Requirements requirements);

    void save(Requirements requirements);

    void update(String requirement, Integer id);

    Optional<Requirements> findOne(Integer id);

    List<Requirements> requirementsList();
}
