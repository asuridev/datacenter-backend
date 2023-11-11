package co.com.freesoft.datacenter.recharge.persistence.repositories;


import co.com.freesoft.datacenter.recharge.persistence.entities.RechargeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface RechargePaginationRepository extends PagingAndSortingRepository <RechargeEntity,Long>{


}

  