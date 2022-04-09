package miu.edu.demo.repo;

import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.Userr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {


    Post findById(long id);
    List<Post> findAll();


    List<Post> findAllByUser(Userr user);
    List<Post> findAllByTitle(String title);
    @Query(value = "SELECT user_id FROM posts GROUP BY user_id HAVING COUNT(user_id) > :count", nativeQuery = true)
    List<Long> findAllByUserCount(int count);
//
//    @Query("SELECT  p FROM Post p WHERE p.author=:author")//JPQL - ch 3 sl 41
//    List<Post> findPostsByAuthor(String author);
//
//    @Query("SELECT  p FROM Post p WHERE p.title =:title")
//    List<Post> findPostsByTitle(String title);
//
//    @Query("SELECT p FROM Post p ,User u where p.id=:postId and u.id=:userId")
//    Post findPostByUserId(int postId,long userId);

//    List<Post> findAll();
//    Post getPostById(int id);
//    void save(Post POST);
//    void delete(int id);
//    void update(int id, Post p);
//
//    List<Post> getPostByAuthor(String test);
}
