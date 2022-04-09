package miu.edu.demo.repo;

 import miu.edu.demo.domain.Userr;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

 import java.util.List;

public interface UserRepo extends CrudRepository<Userr, Long> {

    List<Userr> findAll();
    Userr findById(long id);
    List<Userr> findAllByIdIn(List<Long> user_ids);

    @Query("select u from Userr u where u.post.size > :count") // JBQL query
    List<Userr> findUsersWithGivenNumberOfPosts(int count);

    Userr findByEmail(String username);

}
