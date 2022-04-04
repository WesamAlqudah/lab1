package miu.edu.demo.repo;

import miu.edu.demo.aspect.ExceptionAspect;
import miu.edu.demo.domain.Exception;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExceptionAspectRepo extends CrudRepository<Exception, Long> {
}
