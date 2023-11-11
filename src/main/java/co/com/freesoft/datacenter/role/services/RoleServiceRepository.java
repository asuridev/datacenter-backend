package co.com.freesoft.datacenter.role.services;

import co.com.freesoft.datacenter.role.services.dtos.CreateRoleDto;
import co.com.freesoft.datacenter.role.services.dtos.UpdateRoleDto;
import co.com.freesoft.datacenter.role.services.dtos.RoleDto;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface RoleServiceRepository {

    public RoleDto createRole(CreateRoleDto createRoleDto);

    public Page<RoleDto> findAllRoles(int page, int limit, String sortBy);

    public Optional<RoleDto> findOneRole(String id);

    public Optional<RoleDto> updateRole(UpdateRoleDto updateRoleDto, String id);

    public void removeRole(String id);
}

  