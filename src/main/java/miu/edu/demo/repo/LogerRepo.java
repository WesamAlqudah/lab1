package miu.edu.demo.repo;

 import miu.edu.demo.domain.Logger;
 import miu.edu.demo.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface LogerRepo extends CrudRepository<Logger, Long> {


}
