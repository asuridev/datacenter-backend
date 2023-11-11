package co.com.freesoft.datacenter.user.persistence.repositories;


import co.com.freesoft.datacenter.user.persistence.entities.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserPaginationRepository extends PagingAndSortingRepository <UserEntity,Long>{


}

  