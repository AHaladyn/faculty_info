package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.entity.Authors;
import com.pubsite.pubsite.repository.AuthorsRepository;
import com.pubsite.pubsite.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("authorsService")
@Transactional
public class AuthorsServiceImp implements AuthorsService {

    @Autowired
    private AuthorsRepository authorsRepository;

    public Authors findAuthorsByUserId(Integer userId) {
        return authorsRepository.findAuthorsByUserId(userId);
    }

    @Override
    public void delete(Authors authors) {
        authorsRepository.delete(authors);
    }

    @Override
    public void add(Authors authors) {
        authors.setLastName(authors.getLastName());
        authors.setFirstName(authors.getFirstName());
        authors.setUserId(authors.getUserId());
        authorsRepository.save(authors);
    }

    @Override
    public void save(Authors authors) {
        authorsRepository.saveAndFlush(authors);
    }

    @Override
    public void update(String first_name, String last_name, Integer user_id) {
        authorsRepository.update(first_name, last_name, user_id);
    }

    @Override
    public List<Authors> findByFirstNameAndLastName(String firstName, String lastName) {
        return authorsRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Authors> findByFirstName(String firstName) {
        return authorsRepository.findByFirstName(firstName);
    }

    @Override
    public List<Authors> findByLastName(String lastName) {
        return authorsRepository.findByLastName(lastName);
    }

}
