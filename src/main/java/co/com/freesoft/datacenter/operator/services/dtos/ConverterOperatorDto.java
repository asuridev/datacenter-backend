package co.com.freesoft.datacenter.operator.services.dtos;


import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConverterOperatorDto {

    @Mappings({

    })
    ResponseOperatorDto toResponseOperatorDto(OperatorDto operatorDto);

    List<ResponseOperatorDto> toResponseOperatorDtoList(List<OperatorDto> operatorDtoList);
}
  