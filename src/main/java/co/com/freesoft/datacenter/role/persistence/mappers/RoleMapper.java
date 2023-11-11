package co.com.freesoft.datacenter.role.persistence.mappers;

import co.com.freesoft.datacenter.role.persistence.entities.RoleEntity;
import co.com.freesoft.datacenter.role.services.dtos.CreateRoleDto;
import co.com.freesoft.datacenter.role.services.dtos.UpdateRoleDto;
import co.com.freesoft.datacenter.role.services.dtos.RoleDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {

    ////////////////Entity -> Dto////////////////
    @Mappings({
        @Mapping(target = "role", source = "id")
    })
    RoleDto toRoleDto(RoleEntity roleEntity);


    ////////////////CreateDto -> Entity////////////////
    @Mappings({
        @Mapping(target = "id", source = "role")
    })
    RoleEntity toRoleEntity(CreateRoleDto createRoleDto);

    ////////////////UpdateDto -> Entity////////////////
    @Mappings({
            @Mapping(target = "id", source = "role")
    })
    RoleEntity toRoleEntity(UpdateRoleDto updateRoleDto);

    ////////////Merge Entity with Dto////////////
    @Mappings({
            @Mapping(target = "id", source = "role")
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RoleEntity merge(UpdateRoleDto updateRoleDto, @MappingTarget RoleEntity roleEntity);

    /////////////list Entity-> list Dto////////////
    List<RoleDto> toRoleDtoList(List<RoleEntity> roleEntityList);
    
    /////////////listCreateDto-> list Entity////////////
    List<RoleEntity> toRoleEntityList(List<CreateRoleDto> createRoleDto);

    /////////////listUpdateDto-> list Entity////////////
    List<RoleEntity> toRoleEntityListUpdate(List<UpdateRoleDto> updateRoleDtos);

}
  
  