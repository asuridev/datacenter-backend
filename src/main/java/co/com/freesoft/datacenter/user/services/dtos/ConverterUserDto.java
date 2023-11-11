package co.com.freesoft.datacenter.user.services.dtos;

import co.com.freesoft.datacenter.role.services.dtos.ConverterRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = { ConverterRoleDto.class })
public interface ConverterUserDto {

    @Mappings({

    })
    ResponseUserDto toResponseUserDto(UserDto userDto);

    @Mappings({
            @org.mapstruct.Mapping(target = "token", ignore = true)
    })
    ResponseLoginDto toResponseLoginDto(UserDto userDto);

    List<ResponseUserDto> toResponseUserDtoList(List<UserDto> userDtoList);
}
  