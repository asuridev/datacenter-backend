package co.com.freesoft.datacenter.role.persistence;

import co.com.freesoft.datacenter.role.persistence.entities.RoleEntity;
import co.com.freesoft.datacenter.role.persistence.mappers.RoleMapper;
import co.com.freesoft.datacenter.role.persistence.repositories.RoleCrudRepository;
import co.com.freesoft.datacenter.role.persistence.repositories.RolePaginationRepository;
import co.com.freesoft.datacenter.role.services.RoleServiceRepository;
import co.com.freesoft.datacenter.role.services.dtos.CreateRoleDto;
import co.com.freesoft.datacenter.role.services.dtos.UpdateRoleDto;
import co.com.freesoft.datacenter.role.services.dtos.RoleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleServiceRepository {

    private final RoleCrudRepository roleCrudRepository;
    private final RolePaginationRepository rolePaginationRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleDto createRole(CreateRoleDto createRoleDto) {
        RoleEntity newRole = this.roleMapper.toRoleEntity(createRoleDto);
        RoleEntity responseQuery = this.roleCrudRepository.save(newRole);
        return roleMapper.toRoleDto(responseQuery);
    }

    @Override
    public Page<RoleDto> findAllRoles(int page, int limit, String sortBy) {
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by(sortBy));
        return this.rolePaginationRepository.findAll(pageRequest).map(this.roleMapper::toRoleDto);
    }

    @Override
    public Optional<RoleDto> findOneRole(String id) {
        return this.roleCrudRepository.findById(id).map(this.roleMapper::toRoleDto);
    }

    @Override
    public Optional<RoleDto> updateRole(UpdateRoleDto updateRoleDto, String id) {
        RoleEntity roleEntityById = this.roleCrudRepository.findById(id).orElse(null);
        if(roleEntityById == null) return Optional.empty();;
        RoleEntity roleEntityUpdate = this.roleMapper.merge(updateRoleDto, roleEntityById);
        RoleEntity responseQuery = this.roleCrudRepository.save(roleEntityUpdate);
        return Optional.of(roleMapper.toRoleDto(responseQuery));
    }

    @Override
    public void removeRole(String id) {
        this.roleCrudRepository.deleteById(id);
    }
}

  