package co.com.freesoft.datacenter.role.controller;

import co.com.freesoft.datacenter.role.services.RoleService;
import co.com.freesoft.datacenter.role.services.dtos.CreateRoleDto;
import co.com.freesoft.datacenter.role.services.dtos.UpdateRoleDto;
import co.com.freesoft.datacenter.role.services.dtos.ResponseRoleDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseRoleDto create(@Valid @RequestBody CreateRoleDto createRoleDto){
       return  this.roleService.create(createRoleDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<ResponseRoleDto> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false,defaultValue = "100") int limit,
            @RequestParam(required = false,defaultValue = "id") String sortBy
    ){
        return this.roleService.findAll(page, limit, sortBy);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseRoleDto findOne(@PathVariable("id") String id){
        return this.roleService.findOne(id);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseRoleDto update(@Valid @RequestBody UpdateRoleDto updateRoleDto, @PathVariable("id") String id){
        return this.roleService.update(updateRoleDto, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") String id){
        this.roleService.remove(id);
    }

}

  