package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.entity.Archive;
import com.pubsite.pubsite.repository.ArchiveRepository;
import com.pubsite.pubsite.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArchiveServiceImp implements ArchiveService {

    @Autowired
    private ArchiveRepository archiveRepository;

    @Autowired
    private ArchiveServiceImp(ArchiveRepository archiveRepository) {
        this.archiveRepository = archiveRepository;
    }

    @Override
    public List<Archive> archiveList() {
        return archiveRepository.findAll();
    }

    @Override
    public Optional<Archive> findOne(Integer id) {
        return archiveRepository.findById(id);
    }

    @Override
    public void addArchive(Archive archive) {
        this.archiveRepository.save(archive);
    }

    @Override
    public void deleteArchive(Integer id) {
        archiveRepository.deleteById(id);
        System.out.println("{'message':'Archive deleted'}");
    }
}
