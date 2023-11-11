package co.com.freesoft.datacenter.user.persistence.repositories;


import co.com.freesoft.datacenter.user.persistence.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrudRepository extends CrudRepository <UserEntity,Long>{
  
  Optional<UserEntity> findFirstByUsername(String username);

}

  