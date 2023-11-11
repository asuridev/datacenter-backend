package co.com.freesoft.datacenter.recharge.services.dtos;


import co.com.freesoft.datacenter.operator.services.dtos.ConverterOperatorDto;
import co.com.freesoft.datacenter.user.services.dtos.ConverterUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ConverterOperatorDto.class, ConverterUserDto.class})
public interface ConverterRechargeDto {

    @Mappings({

    })
    ResponseRechargeDto toResponseRechargeDto(RechargeDto rechargeDto);

    List<ResponseRechargeDto> toResponseRechargeDtoList(List<RechargeDto> rechargeDtoList);
}
  