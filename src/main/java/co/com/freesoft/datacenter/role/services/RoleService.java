package co.com.freesoft.datacenter.role.services;

import co.com.freesoft.datacenter.common.exceptions.NotFoundException;
import co.com.freesoft.datacenter.role.services.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleServiceRepository roleServiceRepository;
    private final ConverterRoleDto converterRoleDto;

    public ResponseRoleDto create(CreateRoleDto createRoleDto){
        RoleDto role = roleServiceRepository.createRole(createRoleDto);
        return this.converterRoleDto.toResponseRoleDto(role);
    }

    public Page<ResponseRoleDto> findAll(int page, int limit, String sortBy){
        Page<RoleDto> roles = roleServiceRepository.findAllRoles(page, limit ,sortBy);
        return  roles.map(converterRoleDto::toResponseRoleDto);
    }

    public ResponseRoleDto findOne(String id){
        RoleDto role = roleServiceRepository.findOneRole(id).orElseThrow(NotFoundException::new);
        return this.converterRoleDto.toResponseRoleDto(role);
    }

    public ResponseRoleDto update(UpdateRoleDto updateRoleDto, String id){
        RoleDto role = roleServiceRepository.updateRole(updateRoleDto, id).orElseThrow(NotFoundException::new);
        return this.converterRoleDto.toResponseRoleDto(role);
    }

    public void remove(String id){
        this.findOne(id);
        roleServiceRepository.removeRole(id);
    }
}

  