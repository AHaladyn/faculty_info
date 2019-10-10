package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.entity.Admins;
import com.pubsite.pubsite.repository.AdminsRepository;
import com.pubsite.pubsite.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("adminsService")
@Transactional
public class AdminsServiceImp implements AdminsService {

    @Autowired
    private AdminsRepository adminsRepository;

    public Admins findAdminsByUserId(Integer userId) {
        return adminsRepository.findAdminsByUserId(userId);
    }

    @Override
    public void delete(Admins admins) {
        adminsRepository.delete(admins);
    }

    @Override
    public void add(Admins admins) {
        admins.setLastName(admins.getLastName());
        admins.setFirstName(admins.getFirstName());
        admins.setUserId(admins.getUserId());

        adminsRepository.save(admins);
    }

    @Override
    public void save(Admins admins) {
        adminsRepository.saveAndFlush(admins);
    }

    @Override
    public void update(String first_name, String last_name, Integer user_id) {
        adminsRepository.update(first_name, last_name, user_id);
    }

    @Override
    public List<Admins> findByFirstNameAndLastName(String firstName, String lastName) {
        return adminsRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Admins> findByFirstName(String firstName) {
        return adminsRepository.findByFirstName(firstName);
    }

    @Override
    public List<Admins> findByLastName(String lastName) {
        return adminsRepository.findByLastName(lastName);
    }
}
