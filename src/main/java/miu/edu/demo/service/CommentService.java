package miu.edu.demo.service;

import miu.edu.demo.domain.Comment;
import miu.edu.demo.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {


    void save(CommentDto c);
    List<Comment> getAll();
    Comment findById(long id);

//
//    void addComment(int postId,Comment comment);
//
//    Comment findCommentByPostIdByUserId(int postId, long userId, int commentId);
//
//    List<Comment> findCommentsByPostIdByUserId(int postId, long userId);
}
