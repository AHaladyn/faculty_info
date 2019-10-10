package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.entity.Standards;
import com.pubsite.pubsite.repository.StandardsRepository;
import com.pubsite.pubsite.service.StandardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("standardsService")
@Transactional
public class StandardsServiceImp implements StandardsService {

    @Autowired
    private StandardsRepository standardsRepository;

    public Standards findStandardsByUserId(Integer userId) {
        return standardsRepository.findStandardsByUserId(userId);
    }

    @Override
    public void delete(Standards standards) {
        standardsRepository.delete(standards);
    }

    @Override
    public void add(Standards standards) {
        standards.setLastName(standards.getLastName());
        standards.setFirstName(standards.getFirstName());
        standards.setUserId(standards.getUserId());
        standardsRepository.save(standards);
    }

    @Override
    public void save(Standards standards) {
        standardsRepository.saveAndFlush(standards);
    }

    @Override
    public void update(String first_name, String last_name, Integer user_id) {
        standardsRepository.update(first_name, last_name, user_id);
    }

    @Override
    public List<Standards> findByFirstNameAndLastName(String firstName, String lastName) {
        return standardsRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Standards> findByFirstName(String firstName) {
        return standardsRepository.findByFirstName(firstName);
    }

    @Override
    public List<Standards> findByLastName(String lastName) {
        return standardsRepository.findByLastName(lastName);
    }
}
