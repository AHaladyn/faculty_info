package com.pubsite.pubsite.service;

import com.pubsite.pubsite.entity.Comments;

import java.util.List;
import java.util.Optional;

public interface CommentsService {

    List<Comments> commentsList();

    Optional<Comments> findOne(Integer id);

    void addComment(Comments comments);

    void deleteComment(Integer id);
}
