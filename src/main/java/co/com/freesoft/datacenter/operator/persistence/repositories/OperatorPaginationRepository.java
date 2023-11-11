package co.com.freesoft.datacenter.operator.persistence.repositories;


import co.com.freesoft.datacenter.operator.persistence.entities.OperatorEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface OperatorPaginationRepository extends PagingAndSortingRepository <OperatorEntity,Long>{


}

  