package co.com.freesoft.datacenter.role.persistence.repositories;


import co.com.freesoft.datacenter.role.persistence.entities.RoleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface RolePaginationRepository extends PagingAndSortingRepository <RoleEntity,String>{


}

  