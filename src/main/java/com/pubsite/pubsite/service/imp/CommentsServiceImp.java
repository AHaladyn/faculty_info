package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.entity.Comments;
import com.pubsite.pubsite.repository.CommentsRepository;
import com.pubsite.pubsite.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("commentsService")
public class CommentsServiceImp implements CommentsService {


    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private CommentsServiceImp(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public List<Comments> commentsList() {
        return commentsRepository.findAll();
    }

    @Override
    public Optional<Comments> findOne(Integer id) {
        return commentsRepository.findById(id);
    }

    @Override
    public void addComment(Comments comments) {
        this.commentsRepository.save(comments);
    }

    @Override
    public void deleteComment(Integer id) {
        commentsRepository.deleteById(id);
        System.out.println("{'message':'Comment deleted'}");
    }
}
