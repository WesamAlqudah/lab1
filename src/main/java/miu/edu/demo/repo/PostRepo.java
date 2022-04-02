package miu.edu.demo.repo;

import miu.edu.demo.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {

//    List<Post> findAll();
//    Post getPostById(int id);
//    void save(Post POST);
//    void delete(int id);
//    void update(int id, Post p);
//
//    List<Post> getPostByAuthor(String test);
}
