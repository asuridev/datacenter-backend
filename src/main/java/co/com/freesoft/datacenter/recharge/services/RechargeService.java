package co.com.freesoft.datacenter.recharge.services;

import co.com.freesoft.datacenter.common.exceptions.NotFoundException;
import co.com.freesoft.datacenter.recharge.services.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class RechargeService {

    private final RechargeServiceRepository rechargeServiceRepository;
    private final ConverterRechargeDto converterRechargeDto;

    public ResponseRechargeDto create(CreateRechargeDto createRechargeDto){
        RechargeDto recharge = rechargeServiceRepository.createRecharge(createRechargeDto);
        return this.converterRechargeDto.toResponseRechargeDto(recharge);
    }

    public Page<ResponseRechargeDto> findAll(int page, int limit, String sortBy){
        Page<RechargeDto> recharges = rechargeServiceRepository.findAllRecharges(page, limit ,sortBy);
        return  recharges.map(converterRechargeDto::toResponseRechargeDto);
    }

    public ResponseRechargeDto findOne(Long id){
        RechargeDto recharge = rechargeServiceRepository.findOneRecharge(id).orElseThrow(NotFoundException::new);
        return this.converterRechargeDto.toResponseRechargeDto(recharge);
    }

    public ResponseRechargeDto update(UpdateRechargeDto updateRechargeDto, Long id){
        RechargeDto recharge = rechargeServiceRepository.updateRecharge(updateRechargeDto, id).orElseThrow(NotFoundException::new);
        return this.converterRechargeDto.toResponseRechargeDto(recharge);
    }

    public void remove(Long id){
        this.findOne(id);
        rechargeServiceRepository.removeRecharge(id);
    }
}

  