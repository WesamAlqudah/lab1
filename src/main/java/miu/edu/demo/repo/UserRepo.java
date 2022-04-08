package miu.edu.demo.repo;

 import miu.edu.demo.domain.User;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

 import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findAll();
    User findById(long id);
    List<User> findAllByIdIn(List<Long> user_ids);

    @Query("select u from User u where u.post.size > :count") // JBQL query
    List<User> findUsersWithGivenNumberOfPosts(int count);

    User findByEmail(String username);

}
