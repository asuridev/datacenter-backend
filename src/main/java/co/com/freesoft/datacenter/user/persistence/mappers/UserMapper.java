package co.com.freesoft.datacenter.user.persistence.mappers;
import co.com.freesoft.datacenter.role.persistence.mappers.RoleMapper;
import co.com.freesoft.datacenter.user.persistence.entities.UserEntity;
import co.com.freesoft.datacenter.user.services.dtos.CreateUserDto;
import co.com.freesoft.datacenter.user.services.dtos.UpdateUserDto;
import co.com.freesoft.datacenter.user.services.dtos.UserDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = { RoleMapper.class })
public interface UserMapper {

    ////////////////Entity -> Dto////////////////
    @Mappings({

    })
    UserDto toUserDto(UserEntity userEntity);


    ////////////////CreateDto -> Entity////////////////
    @Mappings({

    })
    UserEntity toUserEntity(CreateUserDto createUserDto);

    ////////////////UpdateDto -> Entity////////////////
    @Mappings({
      @Mapping(target = "id", ignore = true)
    })
    UserEntity toUserEntity(UpdateUserDto updateUserDto);

    ////////////Merge Entity with Dto////////////
    @Mappings({
      @Mapping(target = "id", ignore = true)   
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity merge(UpdateUserDto updateUserDto, @MappingTarget UserEntity userEntity);

    /////////////list Entity-> list Dto////////////
    List<UserDto> toUserDtoList(List<UserEntity> userEntityList);
    
    /////////////listCreateDto -> list Entity////////////
    List<UserEntity> toUserEntityList(List<CreateUserDto> createUserDtos);

    /////////////listUpdateDto -> list Entity////////////
    List<UserEntity> toUserEntityListUpdate(List<UpdateUserDto> updateUserDtos);

}

  