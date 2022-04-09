package miu.edu.demo.repo;

import miu.edu.demo.domain.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

    List<Comment> findAll();
    Comment findById(long id);
//    @Query("SELECT c from Comment c , Post p,Userr u where p.id=:postId and u.id=:userId and c.id=:commentId")
//    Comment findCommentByPostIdByUserId(int postId, long userId, int commentId);
//
//    @Query("SELECT c from Comment c , Post p,Userr u where p.id=:postId and u.id=:userId and c.postLi.id=p.id")
//    List<Comment> findCommentsByPostIdByUserId(int postId, long userId);

}
