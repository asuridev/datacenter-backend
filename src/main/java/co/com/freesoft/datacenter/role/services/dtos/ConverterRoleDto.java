package co.com.freesoft.datacenter.role.services.dtos;


import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConverterRoleDto {

    @Mappings({

    })
    ResponseRoleDto toResponseRoleDto(RoleDto roleDto);

    List<ResponseRoleDto> toResponseRoleDtoList(List<RoleDto> roleDtoList);
}
  