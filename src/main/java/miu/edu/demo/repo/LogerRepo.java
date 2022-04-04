package miu.edu.demo.repo;

import miu.edu.demo.domain.Loger;
import miu.edu.demo.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogerRepo extends CrudRepository<Loger, Long> {


}
