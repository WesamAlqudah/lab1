package miu.edu.demo.repo;

import miu.edu.demo.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role,Long> {
}
