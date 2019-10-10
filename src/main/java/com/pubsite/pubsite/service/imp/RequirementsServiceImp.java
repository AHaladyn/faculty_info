package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.entity.Requirements;
import com.pubsite.pubsite.repository.RequirementsRepository;
import com.pubsite.pubsite.service.RequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("requirementsService")
@Transactional
public class RequirementsServiceImp implements RequirementsService {

    @Autowired
    private RequirementsRepository requirementsRepository;

    @Override
    public void add(Requirements requirements) {
        requirements.setRequirement(requirements.getRequirement());
        requirementsRepository.save(requirements);
    }

    @Override
    public void save(Requirements requirements) {
        requirementsRepository.saveAndFlush(requirements);
    }

    @Override
    public void update(String requirement, Integer id) {
        requirementsRepository.update(requirement, id);
    }

    @Override
    public Optional<Requirements> findOne(Integer id) {
        return requirementsRepository.findById(id);
    }

    @Override
    public List<Requirements> requirementsList() {
        return requirementsRepository.findAll();
    }

}
