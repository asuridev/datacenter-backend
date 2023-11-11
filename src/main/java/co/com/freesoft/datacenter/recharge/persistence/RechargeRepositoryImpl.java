package co.com.freesoft.datacenter.recharge.persistence;

import co.com.freesoft.datacenter.recharge.persistence.entities.RechargeEntity;
import co.com.freesoft.datacenter.recharge.persistence.mappers.RechargeMapper;
import co.com.freesoft.datacenter.recharge.persistence.repositories.RechargeCrudRepository;
import co.com.freesoft.datacenter.recharge.persistence.repositories.RechargePaginationRepository;
import co.com.freesoft.datacenter.recharge.services.RechargeServiceRepository;
import co.com.freesoft.datacenter.recharge.services.dtos.CreateRechargeDto;
import co.com.freesoft.datacenter.recharge.services.dtos.UpdateRechargeDto;
import co.com.freesoft.datacenter.recharge.services.dtos.RechargeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class RechargeRepositoryImpl implements RechargeServiceRepository {

    private final RechargeCrudRepository rechargeCrudRepository;
    private final RechargePaginationRepository rechargePaginationRepository;
    private final RechargeMapper rechargeMapper;

    @Override
    public RechargeDto createRecharge(CreateRechargeDto createRechargeDto) {
        RechargeEntity newRecharge = this.rechargeMapper.toRechargeEntity(createRechargeDto);
        RechargeEntity responseQuery = this.rechargeCrudRepository.save(newRecharge);
        return rechargeMapper.toRechargeDto(responseQuery);
    }

    @Override
    public Page<RechargeDto> findAllRecharges(int page, int limit, String sortBy) {
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by(sortBy));
        return this.rechargePaginationRepository.findAll(pageRequest).map(this.rechargeMapper::toRechargeDto);
    }

    @Override
    public Optional<RechargeDto> findOneRecharge(Long id) {
        return this.rechargeCrudRepository.findById(id).map(this.rechargeMapper::toRechargeDto);
    }

    @Override
    public Optional<RechargeDto> updateRecharge(UpdateRechargeDto updateRechargeDto, Long id) {
        RechargeEntity rechargeEntityById = this.rechargeCrudRepository.findById(id).orElse(null);
        if(rechargeEntityById == null) return Optional.empty();;
        RechargeEntity rechargeEntityUpdate = this.rechargeMapper.merge(updateRechargeDto, rechargeEntityById);
        RechargeEntity responseQuery = this.rechargeCrudRepository.save(rechargeEntityUpdate);
        return Optional.of(rechargeMapper.toRechargeDto(responseQuery));
    }

    @Override
    public void removeRecharge(Long id) {
        this.rechargeCrudRepository.deleteById(id);
    }
}

  