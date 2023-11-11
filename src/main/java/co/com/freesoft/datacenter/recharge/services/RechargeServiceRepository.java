package co.com.freesoft.datacenter.recharge.services;

import co.com.freesoft.datacenter.recharge.services.dtos.CreateRechargeDto;
import co.com.freesoft.datacenter.recharge.services.dtos.UpdateRechargeDto;
import co.com.freesoft.datacenter.recharge.services.dtos.RechargeDto;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface RechargeServiceRepository {

    public RechargeDto createRecharge(CreateRechargeDto createRechargeDto);

    public Page<RechargeDto> findAllRecharges(int page, int limit, String sortBy);

    public Optional<RechargeDto> findOneRecharge(Long id);

    public Optional<RechargeDto> updateRecharge(UpdateRechargeDto updateRechargeDto, Long id);

    public void removeRecharge(Long id);
}

  