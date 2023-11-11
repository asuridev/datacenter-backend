package co.com.freesoft.datacenter.recharge.persistence.mappers;

import co.com.freesoft.datacenter.operator.persistence.mappers.OperatorMapper;
import co.com.freesoft.datacenter.recharge.persistence.entities.RechargeEntity;
import co.com.freesoft.datacenter.recharge.services.dtos.CreateRechargeDto;
import co.com.freesoft.datacenter.recharge.services.dtos.UpdateRechargeDto;
import co.com.freesoft.datacenter.recharge.services.dtos.RechargeDto;
import co.com.freesoft.datacenter.user.persistence.mappers.UserMapper;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {UserMapper.class, OperatorMapper.class})
public interface RechargeMapper {

    ////////////////Entity -> Dto////////////////
    @Mappings({

    })
    RechargeDto toRechargeDto(RechargeEntity rechargeEntity);


    ////////////////CreateDto -> Entity////////////////
    @Mappings({

            @Mapping(target = "id",ignore = true)
    })
    RechargeEntity toRechargeEntity(CreateRechargeDto createRechargeDto);

    ////////////////UpdateDto -> Entity////////////////
    @Mappings({
            @Mapping(target = "id",ignore = true)
    })
    RechargeEntity toRechargeEntity(UpdateRechargeDto updateRechargeDto);

    ////////////Merge Entity with Dto////////////
    @Mappings({
            @Mapping(target = "id",ignore = true)
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RechargeEntity merge(UpdateRechargeDto updateRechargeDto, @MappingTarget RechargeEntity rechargeEntity);

    /////////////list Entity-> list Dto////////////
    List<RechargeDto> toRechargeDtoList(List<RechargeEntity> rechargeEntityList);
    
    /////////////listCreateDto -> list Entity////////////
    List<RechargeEntity> toRechargeEntityList(List<CreateRechargeDto> createRechargeDtos);

    /////////////listUpdateDto -> list Entity////////////
    List<RechargeEntity> toRechargeEntityListUpdate(List<UpdateRechargeDto> updateRechargeDtos);

}

  