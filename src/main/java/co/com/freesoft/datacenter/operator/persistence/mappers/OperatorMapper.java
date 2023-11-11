package co.com.freesoft.datacenter.operator.persistence.mappers;

import co.com.freesoft.datacenter.operator.persistence.entities.OperatorEntity;
import co.com.freesoft.datacenter.operator.services.dtos.CreateOperatorDto;
import co.com.freesoft.datacenter.operator.services.dtos.UpdateOperatorDto;
import co.com.freesoft.datacenter.operator.services.dtos.OperatorDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OperatorMapper {

    ////////////////Entity -> Dto////////////////
    @Mappings({

    })
    OperatorDto toOperatorDto(OperatorEntity operatorEntity);


    ////////////////CreateDto -> Entity////////////////
    @Mappings({

    })
    OperatorEntity toOperatorEntity(CreateOperatorDto createOperatorDto);

    ////////////////UpdateDto -> Entity////////////////
    @Mappings({
            @Mapping(target = "id",ignore = true)
    })
    OperatorEntity toOperatorEntity(UpdateOperatorDto updateOperatorDto);

    ////////////Merge Entity with Dto////////////
    @Mappings({
            @Mapping(target = "id",ignore = true)
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OperatorEntity merge(UpdateOperatorDto updateOperatorDto, @MappingTarget OperatorEntity operatorEntity);

    /////////////list Entity-> list Dto////////////
    List<OperatorDto> toOperatorDtoList(List<OperatorEntity> operatorEntityList);
    
    /////////////listCreateDto -> list Entity////////////
    List<OperatorEntity> toOperatorEntityList(List<CreateOperatorDto> createOperatorDtos);

    /////////////listUpdateDto -> list Entity////////////
    List<OperatorEntity> toOperatorEntityListUpdate(List<UpdateOperatorDto> updateOperatorDtos);

}

  